import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/home/home.routes').then(r => r.HOME_ROUTES)
  },
  {
    path: 'plp',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/catalog/plp/plp.routes').then(r => r.PLP_ROUTES)
  },
  {
    path: 'pdp',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/catalog/pdp/pdp.routes').then(r => r.PDP_ROUTES)
  },
  {
    path: 'checkout',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/user/checkout/checkout.routes').then(r => r.CHECKOUT_ROUTES)
  },
  {
    path: 'login',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/user/login/login.routes').then(r => r.LOGIN_ROUTES)
  },
  {
    path: 'register',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/user/register/register.routes').then(r => r.REGISTER_ROUTES)
  },
  {
    path: 'profile',
    pathMatch: 'prefix',
    loadChildren:()  => import('./pages/user/profile/profile.routes').then(r => r.PROFILE_ROUTES)
  }
];
