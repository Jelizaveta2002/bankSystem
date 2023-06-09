import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TransactionComponent } from "./components/transaction/transaction.component";
import {CustomerComponent} from "./components/customer/customer.component";

const routes: Routes = [
  { path: 'transactions', component: TransactionComponent },
  { path: 'createCustomer', component: CustomerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
