#include<stdio.h>
#define MAX_CUSTOMERS 200

struct BankCustomer {
    int account_number;
    char name[50];
    double balance;
};
void print_customers_with_low_balance(struct BankCustomer* customers, int num_customers) {
    98
    for (int i = 0; i < num_customers; i++) {
        if (customers->balance < 100) {
            printf("Account Number: %d, Name: %s\n", customers->account_number, customers->name);
        }
        *customers++;
    }
}
void handle_customer_transaction(struct BankCustomer* customer, double amount, int code) {
    if (code == 1) { // Deposit
        customer->balance += amount;
        printf("Deposit of Rs. %.2f successful.\n", amount);
    } else if (code == 0) { // Withdrawal
        if (customer->balance >= amount) {
            customer->balance -= amount;
            printf("Withdrawal of Rs. %.2f successful.\n", amount);
        } else {
            printf("The balance is insufficient for the specified withdrawal.\n");
        }
    } else { // Invalid code
        printf("Invalid transaction code.\n");
    }
}
int main() {
    struct BankCustomer customers[MAX_CUSTOMERS] = {
        {1, "Alice", 500},
        {2, "Bob", 75},
        {3, "Charlie", 1000},
        // ...
    };
    int num_customers = 3;

    // Print customers with low balance
    printf("Customers with low balance:\n");
    print_customers_with_low_balance(customers, num_customers);

    // Handle customer transaction
    int account_number = 2;
    double amount = 50;
    int code = 0; // Withdrawal
    struct BankCustomer* customer = NULL;
    for (int i = 0; i < num_customers; i++) {
        if (customers[i].account_number == account_number) {
            customer = &customers[i];
            break;
        }
    }
    if (customer != NULL) {
        handle_customer_transaction(customer, amount, code);
    } else {
        printf("Invalid account number.\n");
    }

    return 0;
}


