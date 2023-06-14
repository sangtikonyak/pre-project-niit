import { Component } from '@angular/core';
import { PRODUCT } from '../model/product';
import { Router } from '@angular/router';
import { AdminServiceService } from '../services/admin-service.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent {
  constructor(private router:Router,private adminService:AdminServiceService){}
 product:PRODUCT={};
 addProductToDatabase(){
  console.log(this.product);
  this.adminService.addProduct(this.product).subscribe(
    {
      next:response=>{
        this.router.navigateByUrl("/admin");
      },
      error:respose=>{
        console.log(respose);
      }
    }
  )
  
 }
}
