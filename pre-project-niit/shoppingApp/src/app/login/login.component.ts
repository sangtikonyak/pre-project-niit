import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';
import { UserInfo } from '../model/signup';
import { MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
   constructor(private authservice: AuthService,private router:Router,private userService:UserServiceService,
    private snackbar:MatSnackBar){}
  user:UserInfo={};
  resposeInfo:any;
 onSubmit(userForm:any){
 // this.authservice.login();
  this.user=userForm.value;
  console.log(this.user);
  this.userService.login(this.user).subscribe({
    next:response=>
    {
      console.log(response);
      this.resposeInfo=response;
      console.log(this.resposeInfo.token);
      console.log(this.resposeInfo.role);
      localStorage.setItem("token",this.resposeInfo.token);
      localStorage.setItem("role",this.resposeInfo.role);
      if(this.resposeInfo.role=="ROLE_ADMIN"){
        this.authservice.login();
        this.router.navigateByUrl("/admin");
        this.snackbar.open('login successfully','welcome',{
          duration:3000,
          panelClass: ['mat-toolbar', 'mat-primary']
        });
      }
      else{
        this.authservice.login();
        this.router.navigateByUrl("/home");
        this.snackbar.open('login successfully','welcome',{
          duration:3000,
          panelClass: ['mat-toolbar', 'mat-primary']
        });
      }
    },
    error:response=>
    {
      console.log(response);
      this.authservice.logout();
      this.snackbar.open('login failed','invalid email or password',{
        duration:3000,
        panelClass: ['mat-toolbar', 'mat-primary']
      });
    }
  })   
 }
}
