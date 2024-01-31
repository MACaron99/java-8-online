import { HttpClient } from "@angular/common/http";
import { httpConfig } from "../app.config";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { ProductPdp } from "../models/product-pdp";

@Injectable({
  providedIn: 'root'
})
export class PdpService {

  private _apiUrl: string = `${httpConfig.apiOpenUrl}/products/pdp/`;

  constructor(private _http: HttpClient) { }

  loadProduct(productId: string): Observable<ProductPdp> {
    return this._http.get<ProductPdp>(`${this._apiUrl}${productId}`);
  }
}
