import { Component } from '@angular/core';
import {CustomerService} from "../../services/customer.service";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent {

  customerData = {
    name: '',
    country: '',
    currencies: [] as string[]
  };
  aavailableCurrencies = ['USD', 'EUR'];

  constructor(private customerService: CustomerService) { }

  createCustomer() {
    this.customerService.createCustomer(this.customerData)
      .subscribe(
        response => {
          // Handle success response
          console.log('Customer created successfully');
        },
        error => {
          // Handle error response
          console.error('Failed to create customer', error);
        }
      );
  }


  toggleCurrency(currency: string) {
    const index = this.customerData.currencies.indexOf(currency);
    if (index > -1) {
      this.customerData.currencies.splice(index, 1); // Remove the currency if already selected
    } else {
      this.customerData.currencies.push(currency); // Add the currency if not selected
    }
  }
}
