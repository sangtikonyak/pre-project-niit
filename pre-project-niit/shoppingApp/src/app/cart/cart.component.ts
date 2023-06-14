import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  constructor(private userService:UserServiceService){};
  productsFromCart:any=[];
  ngOnInit(): void {
    this.userService.getProductFromCart().subscribe(
      {
        next:response=>{
          console.log(response);
          this.productsFromCart=response;
        },
        error:respose=>{
          console.log(respose);
        }
      }
    )
  }

}
