import { Component, OnInit} from '@angular/core';
import { AsyncPipe, NgFor } from "@angular/common";
import { HomeCardComponent } from "./card/home-card.component";
import { Observable} from "rxjs";
import { ProductPlp } from "../../models/product-plp";
import { PlpService } from "../../services/plp.service";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    HomeCardComponent,
    AsyncPipe,
    NgFor
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {

  products$!: Observable<ProductPlp[]>;

  constructor(private _plpService: PlpService) { }

  ngOnInit(): void {
    this.products$ = this._plpService.loadTopProducts();
  }
}
