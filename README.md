# 🏦 Bank System — Java OOP Project

A console-based banking system built in Java, demonstrating core Object-Oriented Programming concepts through a real-world banking scenario.

---

## 📋 Table of Contents

- [About](#about)
- [Features](#features)
- [Project Structure](#project-structure)
- [Classes Overview](#classes-overview)
- [OOP Concepts Used](#oop-concepts-used)
- [How to Run](#how-to-run)
- [Sample Output](#sample-output)

---

## About

This project simulates a simple banking system where users can enter savings account details through the console. The system validates all inputs and displays accounts with a balance greater than $1000.

---

## Features

- Add 5 savings accounts interactively
- Full input validation for all fields
- Detects and rejects duplicate account numbers
- Displays only accounts with balance greater than $1000
- Supports both English and Arabic owner names

---

## Project Structure

```
banksystem/
│
├── Account.java          # Base class
├── SavingsAccount.java   # Inherits from Account
└── BankSystem.java       # Main driver class
```

---

## Classes Overview

### `Account` — Base Class
Represents a general bank account.

| Field | Type | Description |
|-------|------|-------------|
| `accountNumber` | `String` | 8–16 digit unique identifier |
| `ownerName` | `String` | Letters only (English or Arabic) |
| `balance` | `double` | Must be non-negative |

**Methods:** `deposit()`, `withdraw()`, `transfer()`, `toString()`

---

### `SavingsAccount` — Extends Account
Adds savings-specific fields on top of Account.

| Field | Type | Description |
|-------|------|-------------|
| `interestRate` | `double` | Between 0 and 100 |
| `minimumBalance` | `double` | Must be non-negative |

**Methods:** `calculateInterest()`, `applyInterest()`, `toString()`

---

### `BankSystem` — Main Class
Handles user interaction and program flow.

| Method | Description |
|--------|-------------|
| `main()` | Entry point |
| `dataFill()` | Reads and validates user input |
| `dataPrint()` | Displays accounts with balance > $1000 |
| `isAccountExists()` | Checks for duplicate account numbers |

---

## OOP Concepts Used

- **Encapsulation** — All fields are `private`, accessed via getters/setters with validation
- **Inheritance** — `SavingsAccount` extends `Account`
- **Method Overriding** — `toString()` overridden in both subclasses
- **Abstraction** — Logic separated across focused classes

---

## Sample Output

```
--- Enter details for Account 1 ---
Account Number: 12345678
Owner Name: Ahmad Ali
Balance ($): 1500
Interest Rate (%): 3.5
Minimum Balance ($): 200

All accounts added successfully!

========================================
Accounts with balance greater than $1000
========================================
Account Number: 12345678 | Owner: Ahmad Ali | Balance: $1500.0 | Interest Rate: 3.5% | Minimum Balance: $200.0
```
