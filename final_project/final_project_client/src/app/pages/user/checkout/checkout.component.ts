import { Component } from '@angular/core';
import { RouterLink } from "@angular/router";
import { FormsModule } from "@angular/forms";
import { NgIf } from "@angular/common";

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    NgIf
  ],
  templateUrl: './checkout.component.html',
  styleUrl: './checkout.component.scss'
})
export class CheckoutComponent { }
