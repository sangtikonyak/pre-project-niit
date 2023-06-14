import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  constructor(private httpClient:HttpClient) { }
  productBaseUrl:string='http://localhost:8081/product';

  getAllProducts(){
    return this.httpClient.get(`${this.productBaseUrl}/getAll-products`);
  }
  updateProduct(product:any){
    let httpHeaders=new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem("token")
    });
    let requestOptions={headers : httpHeaders};
    return this.httpClient.put(`${this.productBaseUrl}/v1/admin/update`,product,requestOptions);
  }
 deleteProduct(productId:any){
    let httpHeaders=new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem("token")
    });
    let requestOptions={headers : httpHeaders};
    return this.httpClient.delete(`${this.productBaseUrl}/v1/admin/delete/${productId}`,requestOptions);
  }
  searchProduct(productName:any){
    let httpHeaders=new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem("token")
    });
    let requestOptions={headers : httpHeaders};
    return this.httpClient.get(`${this.productBaseUrl}/v1/get-product/${productName}`,requestOptions);
  }
  addProduct(product:any){
    let httpHeaders=new HttpHeaders({
      'Authorization' : 'Bearer ' + localStorage.getItem("token")
    });
    let requestOptions={headers : httpHeaders};
    return this.httpClient.post(`${this.productBaseUrl}/v1/admin/add-product`,product,requestOptions);
  }
}
