import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from "rxjs";
import { ProductPlp } from "../../../models/product-plp";
import { FavoritesService } from "../../../services/favorites.service";
import { AsyncPipe, NgForOf, NgIf } from "@angular/common";
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [
    AsyncPipe,
    NgIf,
    NgForOf,
    RouterLink
  ],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.scss'
})
export class ProfileComponent implements OnInit, OnDestroy {

  products: ProductPlp[] = [] as ProductPlp[];
  private _subscription = new Subscription();

  constructor(private _favoritesService: FavoritesService,
  ) { }

  ngOnInit(): void {
    this._subscription.add(
      this._favoritesService.loadFavorites().subscribe(
        response => {
          this.products = response;
        }
      )
    )
  }

  removeFromFavorites(productId: number): void {
    this._subscription.add(
      this._favoritesService.removeFromFavorites(productId).subscribe(
        response => {
          console.log('Favorites deleted:', response);
        },
        error => {
          console.error('Error deleting from favorites:', error);
        }
      )
    )
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }
}
