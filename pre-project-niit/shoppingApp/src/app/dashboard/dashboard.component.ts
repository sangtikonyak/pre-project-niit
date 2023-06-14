import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../services/user-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
constructor(private userservice:UserServiceService,private snackbar:MatSnackBar){}
products:any=[];
  ngOnInit(): void {
    this.userservice.getAllProduct().subscribe(
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
  addProductToCart(product:any){
    this.userservice.addProductToCart(product).subscribe(
      {
        next:response=>{
          console.log(response);

          this.snackbar.open('added to card','successfully',{
            duration:3000,
            panelClass: ['mat-toolbar', 'mat-primary']
          });        },
        error:respose=>{
          console.log(respose);
        }
      }
    )
  }

}
