//============================================================================
// Name        : Assignment-2(Q2).cpp
// Author      : nehal
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <string>
using namespace std;

class BankAccount {
private:
    int accountNumber;
    string accountHolderName;
    double balance;

public:
    // Constructor to initialize account details
    BankAccount(int accNumber, string accHolderName, double initialBalance) {
        accountNumber = accNumber;
        accountHolderName = accHolderName;
        balance = initialBalance;
    }

    // Getter and Setter Methods
    int getAccountNumber() {
        return accountNumber;
    }

    void setAccountNumber(int accNumber) {
        accountNumber = accNumber;
    }

    string getAccountHolderName() {
        return accountHolderName;
    }

    void setAccountHolderName(string accHolderName) {
        accountHolderName = accHolderName;
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double newBalance) {
        balance = newBalance;
    }

    // Deposit method to deposit money into the account
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            cout << "Deposited: " << amount << endl;
            cout << "Updated Balance: " << balance << endl;
        } else {
            cout << "Invalid deposit amount!" << endl;
        }
    }

    // Withdraw method to withdraw money from the account
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            cout << "Withdrawn: " << amount << endl;
            cout << "Updated Balance: " << balance << endl;
        } else if (amount <= 0) {
            cout << "Invalid withdrawal amount!" << endl;
        } else {
            cout << "Insufficient balance!" << endl;
        }
    }

    // Display account details
    void displayAccountDetails() {
        cout << "\nAccount Details: \n";
        cout << "Account Number: " << accountNumber << endl;
        cout << "Account Holder Name: " << accountHolderName << endl;
        cout << "Balance: " << balance << endl;
    }
};

int main() {
    int accNumber;
    string accHolderName;
    double initialBalance;

    // Input account details to create a new account
    cout << "Enter account number: ";
    cin >> accNumber;
    cout << "Enter account holder name: ";
    cin.ignore();  // to ignore the newline character left by cin
    getline(cin, accHolderName);
    cout << "Enter initial balance: ";
    cin >> initialBalance;

    // Create a BankAccount object
    BankAccount account(accNumber, accHolderName, initialBalance);

    int choice;
    double amount;

    while (true) {
        cout << "\nMenu:\n";
        cout << "1. Deposit money\n";
        cout << "2. Withdraw money\n";
        cout << "3. Display account details\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        if (choice == 1) {
            cout << "Enter amount to deposit: ";
            cin >> amount;
            account.deposit(amount);
        }
        else if (choice == 2) {
            cout << "Enter amount to withdraw: ";
            cin >> amount;
            account.withdraw(amount);
        }
        else if (choice == 3) {
            account.displayAccountDetails();
        }
        else if (choice == 4) {
            cout << "Exiting the program.\n";
            break;
        }
        else {
            cout << "Invalid choice! Please try again.\n";
        }
    }

    return 0;
}

