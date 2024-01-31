import {Component, Input, OnDestroy} from '@angular/core';
import {ProductPlp} from "../../../../models/product-plp";
import {PlpService} from "../../../../services/plp.service";
import {AuthService} from "../../../../services/auth.service";
import {FavoritesService} from "../../../../services/favorites.service";
import {Router, RouterLink} from "@angular/router";
import {AsyncPipe, NgIf} from "@angular/common";
import {Observable, Subscription} from "rxjs";
import {SharedModule} from "../../../../models/shared.module";

@Component({
  selector: 'app-plp-card',
  standalone: true,
  imports: [
    RouterLink,
    AsyncPipe,
    NgIf,
    SharedModule
  ],
  templateUrl: './plp-card.component.html',
  styleUrl: './plp-card.component.scss'
})
export class PlpCardComponent implements OnDestroy {

  @Input() product!: ProductPlp;
  isLoggedIn$: Observable<boolean> = this._authService.isLoggedIn();
  private _subscription = new Subscription();

  constructor(private _authService: AuthService, private _favoritesService: FavoritesService) { }

  addToFavorites(productId: number): void {
    this._subscription.add(
      this._favoritesService.addToFavorites(productId).subscribe(
        response => {
          console.log('Favorites added:', response);
        },
        error => {
          console.error('Error adding to favorites:', error);
        }
      )
    )
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }
}
