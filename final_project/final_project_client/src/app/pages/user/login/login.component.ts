import { Component, OnDestroy } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";
import { NgIf } from "@angular/common";
import { Subscription } from "rxjs";
import { AuthService } from "../../../services/auth.service";
import { Router } from "@angular/router";
import { RegisterData } from "../../../models/register-data";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnDestroy {

  private _subscription = new Subscription();

  constructor(private _formBuilder: FormBuilder, private _authService: AuthService, private _router: Router) { }


  form: FormGroup = this._formBuilder.group({
    email: new FormControl(null, [Validators.required, Validators.email]),
    password: new FormControl(null, [Validators.required])
  });

  login(): void {
    if (this.form.valid) {
      console.log(this.form);
      let data: RegisterData = { ...this.form.value };
      this._subscription.add(
        this._authService.login(data).subscribe(
          (auth) => {
            console.log('auth', auth);
            localStorage.setItem('token', JSON.stringify(auth));
            this._authService.setLoggedIn(true);
            this._router.navigateByUrl('/plp')
          },
          (error) => {
            console.log('error', error);
            localStorage.removeItem('token');
            this._authService.setLoggedIn(false);
          }
        )
      )
    }
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }
}
