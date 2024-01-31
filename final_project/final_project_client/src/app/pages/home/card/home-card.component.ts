import { Component, Input } from '@angular/core';
import { ProductPlp } from "../../../models/product-plp";
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-home-card',
  standalone: true,
  imports: [
    RouterLink,
  ],
  templateUrl: './home-card.component.html',
  styleUrl: './home-card.component.scss'
})
export class HomeCardComponent  {

  @Input() product!: ProductPlp;
}
