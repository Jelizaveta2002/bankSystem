# Setting up Application

In order to run application it is needed to run docker-compose.yml file and then
run Dockerfile (it is possible to run by typing command "docker compose up") in
terminal. Note that nothing should be run on ports 8080, 5432, 15672, 5672.
Add postgres database with url: jdbc:postgresql://postgres:5432/postgres
user: springbootuser, password:springbootpass.
Run BankSystemApplication.

## Database

I use Liquibase and chengelogs for database creation.
In database I have 5 tables related to application. Accounts, balances, 
currencies, transactions. There are foreign keys and primary keys that are used
for creating relations between data. 

## Back-End
For communication with database I use MyBatis sql requests that are located in
util package.

Totally 4 entities: Account, Balance, Customer, Transactions.
Customer creation: This function is called by
insert() in CustomerService where input object is a CustomerDTO.
When customer is created currencies that customer supports are added into
currencies table with foreign key customerId.

Account creation: using addAccount() method there are automatically created 
account for a particular customer and also balances for all the supported
currencies. Amount default value is 0.

Transaction: transaction is created considering all the requirements.
It is checked that account_id exists and it supports a currency. If
direction is OUT so it is checked that there is enough money for 
creating a transaction. Invalid amount is also checked.
Information about transaction is sent to RabbitMQ every time when 
transaction is created.
RabbitMQ messages is possible o see going on http://localhost:15672.
Username: guest, password: guest. -> Queue -> Get message(s).

Errors: IllegalArgumentExceptions with informative message
are thrown if some actions were not successful.

## Tests
Tests can be found in package test.

## How it works
We can use Postman for example.
Create POST request: http://localhost:8080/api/customer/addCustomer
Add Body to our request: 

{
"name": "Piiret",
"country": "Latvia",
"currencies": [
"USD",
"EUR"
]
}

Response: 
{
"id": 11,
"name": "Piiret",
"country": "Latvia",
"currency": [
"USD",
"EUR"
]
}

Create account for Customer with id=11 using GET request: 
http://localhost:8080/api/account/addAccount?id=11
Response: {
"id": 19,
"customer_id": 11,
"listOfBalances": [
{
"id": 31,
"amount": 0,
"currency": "USD",
"account_id": 19
},
{
"id": 32,
"amount": 0,
"currency": "EUR",
"account_id": 19
}
]
}

Now we have a new account for Customer with 2 balances for each currency.
We can get this account by creating request: http://localhost:8080/api/account/getAccount?account_id=19

When account is created successfully it is possible to
make a transaction.

We use GET request:
http://localhost:8080/api/transAction/addTrans?account_id=19&amount=13&currencies=USD&direction=IN&description=AddMoney

Response:
{
"id": 41,
"account_id": 19,
"amount": 13,
"currency": "USD",
"description": "AddMoney",
"balance": {
"id": 31,
"amount": 13,
"currency": "USD",
"account_id": 19
},
"balance_id": 31,
"direction": "IN"
}

We can notice that amount of balance increased.

NB ! If some arguments are incorrect (currency is invalid, not enough money on balance and etc.)
we get an exception with a message.

It is also possible to get all existing transactions:
http://localhost:8080/api/transAction/getTransactions

## Additional Information
For my project I used some materials from one of my university projects: https://github.com/Jelizaveta2002/iti0302-frontend
I also used some tips from https://stackoverflow.com/ and https://chat.openai.com/chat
mostly for working with MyBatis and RabbitMQ that I have not used before.




