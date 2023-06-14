import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  userBaseUrl:string="http://localhost:8080/api/v1";
  
  constructor(private httpClient:HttpClient) { }
  
  signUp(userSignUp:any){
  
     return this.httpClient.post(`${this.userBaseUrl}/signup`,userSignUp);
   // return this.httpClient.post('http://localhost:9000/api/v1/signup',userSignUp);
  }
  
  login(loginData:any){
   return this.httpClient.post(`${this.userBaseUrl}/login`,loginData);
  }

  getAllProduct(){
    return this.httpClient.get("http://localhost:8081/product/getAll-products");
  }

  getProductFromCart(){
    let httpHeaders=new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem("token")
    });
    let requestOptions={headers : httpHeaders};
    console.log(requestOptions);
    return this.httpClient.get("http://localhost:8081/product/v1/cart-product",requestOptions);
  }
  addProductToCart(product:any){
    let httpHeaders=new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem("token")
    });
    let requestOptions={headers : httpHeaders};
    console.log(requestOptions);
    return this.httpClient.post("http://localhost:8081/product/v1/add-product",product,requestOptions);
  }
}
