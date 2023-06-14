import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { AdminServiceService } from '../services/admin-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  constructor(private authService:AuthService,private router:Router,private adminService:AdminServiceService,
    private snackBar:MatSnackBar){}
  products:any=[];
  updateForm:boolean=false;
  productDetails:any={};
  productName:string='';
  ngOnInit(): void {
    this.adminService.getAllProducts().subscribe(
      {
        next:response=>{
          console.log(response);
          this.products=response;
        },
        error:respose=>{
          console.log(respose);
        }
      }
    )
  }
  logout(){
    this.authService.logout();
     this.router.navigateByUrl('/login');
   }
   update(product:any){
   console.log(product.value);
   this.adminService.updateProduct(product.value).subscribe(
    
    {
      next:response=>{
        //console.log(response);
        this.products=response;
        this.snackBar.open('updated','successfully',{
          duration:3000,
          panelClass: ['mat-toolbar', 'mat-primary']
        });
        this.updateForm=false;
      },
      error:respose=>{
        console.log(respose);
      }
    }
   )
   
   }
   getProduct(product:any){
    this.productDetails=product;
   this.updateForm=true;
   }
   searchProduct(){
    console.log(this.productName);
    this.adminService.searchProduct(this.productName).subscribe(
      {
        next:response=>{
        this.products=response;
         console.log(this.products);
        },
        error:respose=>{
          console.log(respose);
        }
      }
    )
   }
 deleteProduct(productId:string){
this.adminService.deleteProduct(productId).subscribe(
  {
    next:response=>{
      console.log(response);
      this.products=response;
    },
    error:respose=>{
      console.log(respose);
    }
  }
)

 }
 goToAddProduct(){
  this.router.navigateByUrl("/add-product");
 }
}
