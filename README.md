# Enterprise Banking System (CLI)

A robust, console-based banking application built in Java. This project demonstrates professional software engineering practices, including **MVC (Model-View-Controller)** architecture, strict encapsulation, exception handling, and session management.

## 🚀 Features

* **Secure Authentication:** User login validation using Account ID.
* **Transaction Management:**
    * Deposit funds with positive value validation.
    * Withdraw funds with sufficient balance checks.
    * Real-time balance inquiry.
* **Session Control:**
    * Interactive menu with "Continue/Exit" logic.
    * **Auto-Reset Feature:** System automatically resets and pauses for 15 seconds after a user logs out, simulating a real-world ATM or kiosk terminal.
* **Error Handling:** graceful handling of invalid inputs (text instead of numbers) and business logic errors (negative deposits, overdrafts).

## 🛠️ Technology Stack

* **Language:** Java (JDK 8+)
* **Architecture:** Layered Architecture (Model, Service, App)
* **Interface:** Command Line Interface (CLI)

## 📂 Project Structure

The project follows a modular "Separation of Concerns" design:

```text
src/
└── com/
    └── banking/
        ├── model/
        │   └── Customer.java      # POJO: Data definition (Private fields)
        ├── service/
        │   └── BankService.java   # Logic: Rules, calculations, and data repository
        └── app/
            └── BankApplication.java # UI: Main entry point, user input, and menu loop
