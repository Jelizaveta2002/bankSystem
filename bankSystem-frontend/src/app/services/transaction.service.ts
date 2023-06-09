import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Transaction} from "../models/transaction";

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(
    private http: HttpClient,
  ) { }

  getTransactions():Observable<Transaction[]> {
    return this.http.get<Transaction[]>('http://localhost:8080/api/transAction/getTransactions');
  }
}
