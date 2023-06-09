import { Component, OnInit } from '@angular/core';
import { Transaction } from "../../models/transaction";
import { Observable } from "rxjs";
import { TransactionService } from "../../services/transaction.service";

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  transactions: Transaction[] = [];
  transactions$!:Observable<Transaction[]>

  constructor(private transService: TransactionService) { }

  ngOnInit(): void {
    this.getTransactions();
  }

  getTransactions() {
    this.transactions$ = this.transService.getTransactions();
  }
}
