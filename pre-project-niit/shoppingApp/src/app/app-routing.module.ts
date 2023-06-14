import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { CartComponent } from './cart/cart.component';
import { authGuard } from './auth.guard';
import { AddProductComponent } from './add-product/add-product.component';

const routes: Routes = [
  
  {
    path:"home",
    component:DashboardComponent,
    canActivate:[authGuard]
  },
  {
    path:"",
    redirectTo:"/login",
    pathMatch:"full"
  },
  {
    path:"login",
    component:LoginComponent
  },
  {
    path:"signup",
    component:SignupComponent
  },
  {
    path:"admin",
    component:AdminDashboardComponent,
    canActivate:[authGuard]
  },
  {
    path:"add-product",
    component:AddProductComponent,
    canActivate:[authGuard]
  },
  {
    path:"cart-view",
    component:CartComponent,
    canActivate:[authGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
