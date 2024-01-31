import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { AsyncPipe, JsonPipe, NgClass, NgForOf, NgIf, NgOptimizedImage } from "@angular/common";
import { Observable, Subscription } from "rxjs";
import { PdpService } from "../../../services/pdp.service";
import { ProductPdp } from "../../../models/product-pdp";
import { Router, RouterLink } from "@angular/router";
import { AuthService } from "../../../services/auth.service";
import { FavoritesService } from "../../../services/favorites.service";

@Component({
  selector: 'app-pdp',
  standalone: true,
  imports: [
    NgIf,
    AsyncPipe,
    JsonPipe,
    NgForOf,
    NgOptimizedImage,
    RouterLink,
    NgClass
  ],
  templateUrl: './pdp.component.html',
  styleUrl: './pdp.component.scss'
})
export class PdpComponent implements OnInit, OnDestroy {

  activeImageIndex = 0;
  isLoggedIn$: Observable<boolean> = this._authService.isLoggedIn();
  private _url = this._router.routerState.snapshot.url;
  private  _productId = this._url.substring(this._url.lastIndexOf('/') + 1);
  private _subscription = new Subscription();
  @Input() product: ProductPdp = {} as ProductPdp;

  constructor(private _authService: AuthService,
              private _favoritesService: FavoritesService,
              private _pdpService: PdpService,
              private _router: Router
  ) { }

  ngOnInit(): void {
    this._subscription.add(
      this._pdpService.loadProduct(this._productId).subscribe(p => {
        this.product = p;
      })
    )
  }

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

  setActiveImage(index: number) {
    this.activeImageIndex = index;
  }

  sortedProductImages() {
    return this.product.images.sort();
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }
}
