import { Component } from '@angular/core';
import { AsyncPipe, NgIf } from "@angular/common";
import { RouterLink } from "@angular/router";
import { AuthService } from "../../../services/auth.service";
import { Observable } from "rxjs";

@Component({
  selector: 'app-header',
  standalone: true,
    imports: [
        AsyncPipe,
        NgIf,
        RouterLink
    ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

  isLoggedIn$: Observable<boolean> = this._authService.isLoggedIn();

  constructor(private _authService: AuthService) { }

  logout(): void {
    localStorage.removeItem('token');
    this._authService.setLoggedIn(false);
  }
}
