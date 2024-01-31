import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { httpConfig } from "../app.config";
import { Injectable } from "@angular/core";
import { AuthService } from "./auth.service";
import { Observable } from "rxjs";
import { ProductPlp } from "../models/product-plp";

@Injectable({
  providedIn: "root"
})
export class FavoritesService {

  private _apiUrl: string = `${httpConfig.apiPersonalUrl}/favorites`;

  constructor(private _http: HttpClient, private _authService: AuthService) { }

  addToFavorites(productId: number): Observable<string> {
    let token = this._authService.getToken();
    let headers = new HttpHeaders();
    let params = new HttpParams();
    headers = headers.set('Authorization', `Bearer ${token}`);
    params = params.set('productId', productId);
    let options = { params, headers };
    return this._http.post<string>(`${this._apiUrl}/add`, null, options);
  }

  loadFavorites(): Observable<ProductPlp[]> {
    let token = this._authService.getToken();
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', `Bearer ${token}`);
    let options = { headers };
    return this._http.get<any>(`${this._apiUrl}/get`, options);
  }

  removeFromFavorites(productId: number): Observable<string> {
    let token = this._authService.getToken();
    let headers = new HttpHeaders();
    let params = new HttpParams();
    headers = headers.set('Authorization', `Bearer ${token}`);
    params = params.set('productId', productId.toString());
    let options = { params, headers };
    return this._http.post<string>(`${this._apiUrl}/delete`, null, options);
  }
}
