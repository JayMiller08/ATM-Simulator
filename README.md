# ATM Simulator

A Java-based ATM (Automated Teller Machine) simulator that provides basic banking operations through a command-line interface.

## Features

- Account Setup
  - Create a 4-digit PIN during initial setup
  - Random initial balance between R1,000 and R11,000

- Banking Operations
  1. Check Balance
  2. Deposit Money
  3. Withdraw Money
  4. Change PIN
  5. Exit
  6. View Account Details

## Security Features

- PIN Protection
  - 3 attempts maximum for PIN verification
  - Secure PIN change functionality requiring old PIN verification
  
- Transaction Limits
  - Maximum withdrawal limit of R5,000 per transaction
  - Withdrawals must be multiples of 10
  - Cannot withdraw more than available balance

## Transaction Details

- Transaction Reference Number
  - Unique reference number generated for deposits and withdrawals
  - Format: 5-digit number between 10000 and 99999

- Transaction Counter
  - Tracks the number of transactions performed in the session
  - Displays running balance after each transaction

## Requirements

- Java Runtime Environment (JRE)
- Java Development Kit (JDK) for compilation
- Console/Terminal for interaction

## How to Run

1. Compile the program:
   ```bash
   javac ATMSimulator.java
   ```

2. Run the compiled program:
   ```bash
   java ATMSimulator
   ```

## Usage Instructions

1. Upon starting, create a 4-digit PIN when prompted
2. Select operations from the main menu using numbers 1-6
3. Follow on-screen prompts for each operation
4. After each transaction, choose to continue (Y) or exit (N)
5. The program displays total transactions and final balance upon exit

## Limitations

- No persistent storage (data is lost after program termination)
- Single account simulation
- No card number implementation
- No transaction history storage

## Error Handling

- Invalid menu selections are caught and reported
- Insufficient funds are checked before withdrawals
- Invalid PIN entries are tracked and limited
- Input validation for withdrawal amounts
- Case-insensitive Y/N processing for continue/exit prompt

## Developer Notes

- Uses `java.util.Scanner` for user input
- Uses `java.util.Random` for generating random values
- Implements basic error checking and input validation
- Maintains session-based transaction counting

## Bank Details

Institution: TOMBO BANK  
Currency: Rand (R)  
Maximum Daily Withdrawal: R5,000
