import {Component, OnDestroy, OnInit} from '@angular/core';
import { AsyncPipe, JsonPipe, NgForOf, NgIf, NgOptimizedImage } from "@angular/common";
import {map, Subscription} from "rxjs";
import { ProductPlp } from "../../../models/product-plp";
import { PlpService } from "../../../services/plp.service";
import { Router } from "@angular/router";
import { PlpCardComponent } from "./card/plp-card.component";
import { ReactiveFormsModule } from "@angular/forms";

@Component({
  selector: 'app-plp',
  standalone: true,
  imports: [
    NgIf,
    AsyncPipe,
    JsonPipe,
    NgForOf,
    NgOptimizedImage,
    PlpCardComponent,
    ReactiveFormsModule
  ],
  templateUrl: './plp.component.html',
  styleUrl: './plp.component.scss'
})
export class PlpComponent implements OnInit, OnDestroy {

  private _subscription = new Subscription();

  constructor(private _plpService: PlpService, private _router: Router) { }

  products!: ProductPlp[];

  ngOnInit(): void {
    this._subscription.add(
      this._plpService.loadProducts().subscribe(res => {
        this.products = res;
      })
    )
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }

  onChange(val: any): ProductPlp[] {
    let sort = [];

    if (val.value === 'sortDefault') {
      sort = this.products.sort((a, b) => Number(b.id) - Number(a.id));
      this.products = sort;
    }

    if (val.value === 'sortToHightPrice') {
      sort = this.products.sort((a, b) => a.price - b.price);
      this.products = sort;
    }

    if (val.value === 'sortToLowPrice') {
      sort = this.products.sort((a, b) => b.price - a.price);
      this.products = sort;
    }

    if (val.value === 'sortAZ') {
      sort = this.products.sort((a, b) => a.name.localeCompare(b.name));
      this.products = sort;
    }

    if (val.value === 'sortZA') {
      sort = this.products.sort((a, b) => b.name.localeCompare(a.name));
      this.products = sort;
    }

    return this.products
  }

  filter(from: number, to?: number) {

    this._plpService.loadProducts().pipe(
      map(arr => arr.filter(p =>
        !to
          ? p.price > from
          : p.price > from && p.price <= to)
      ))
      .subscribe(arr => {
        this.products = arr;
      });

  }
}
