Bonus assignment 1

Account

nbr : String
balance : double
credit(double amount) : void
withdraw(double amount) : void

A) Implement the Bank bankAccount class.
 All variables should be private with public methods.
 The method ”credit” adds value to the variable ”balance” by addition of the variable
”balance” and the parameter ”amount”.
 The method ”withdraw” reduces the value of the variable ”balance” by subtraction of the
variable ”balance” and the parameter ”amount”.

B) Also implement a test method (a main method) that tries out all the methods of the class Bank
bankAccount.

C) Write an application where you can deposit and withdraw a certain amount on an bankAccount several
times (through a while loop). The program should close down when you press ”Y” to the question
”Would you like to exit?”.

    Example:
    Deposit or withdrawal (0-deposit, 1-withdrawal): 0
    Enter amount: 100
    Balance: 100
    Would you like to exit? N
    Deposit or withdrawal (0-deposit, 1-withdrawal): 0
    Enter amount: 200
    Balance: 300
    Would you like to exit? N
    Deposit or withdrawal (0-deposit, 1-withdrawal): 1
    Enter amount: 100
    Balance: 200
    Would you like to exit? Y
    Balance: 200