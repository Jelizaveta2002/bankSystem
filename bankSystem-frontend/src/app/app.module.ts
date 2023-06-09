import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; // Import HttpClientModule

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {TransactionComponent} from "./components/transaction/transaction.component";
import {MatCardModule} from "@angular/material/card";
import {MatListModule} from "@angular/material/list";
import { CustomerComponent } from './components/customer/customer.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    TransactionComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, // Add HttpClientModule to imports
    AppRoutingModule,
    MatCardModule,
    MatListModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
