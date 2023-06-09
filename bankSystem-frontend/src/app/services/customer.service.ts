import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private apiUrl = 'http://localhost:8080/api/customer/addCustomer';
  constructor(private http: HttpClient) { }

  createCustomer(customerData: any) {
    return this.http.post(this.apiUrl , customerData);
  }
}
