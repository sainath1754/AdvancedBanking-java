package com.banking.app;

import com.banking.model.Customer;
import com.banking.service.BankService;
import java.util.Scanner;

public class BankApplication {
    
    private static final Scanner sc = new Scanner(System.in);
    private static final BankService service = new BankService();

    public static void main(String[] args) {
        // MAIN SERVER LOOP (Runs forever until forcefully stopped)
        while (true) {
            System.out.println("\n=== WELCOME TO ENTERPRISE BANKING SYSTEM ===");
            System.out.print("Enter your Account Number to login: ");
            
            int accNum = getIntInput();
            
            try {
                // Attempt Login
                Customer activeUser = service.authenticate(accNum);
                startUserSession(activeUser);
                
                // --- END OF SESSION LOGIC ---
                System.out.println("\nThank you for banking with us, " + activeUser.getName() + "!");
                System.out.println("Session closed. System will reset in 15 seconds...");
                
                // Pause for 15 seconds
                Thread.sleep(15000); 
                
            } catch (InterruptedException ie) {
                System.out.println("System interrupted.");
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }
    }

    private static void startUserSession(Customer user) {
        boolean sessionActive = true;

        while (sessionActive) {
            printMenu();
            int choice = getIntInput();

            try {
                switch (choice) {
                    case 1: // Details
                        System.out.println("\n>> DETAILS: " + user);
                        break;
                    case 2: // Balance
                        System.out.println("\n>> CURRENT BALANCE: $" + user.getBalance());
                        break;
                    case 3: // Deposit
                        System.out.print("Enter deposit amount: ");
                        double depAmt = getDoubleInput();
                        service.deposit(user, depAmt);
                        System.out.println(">> Success! New Balance: $" + user.getBalance());
                        break;
                    case 4: // Withdraw
                        System.out.print("Enter withdrawal amount: ");
                        double withAmt = getDoubleInput();
                        service.withdraw(user, withAmt);
                        System.out.println(">> Success! New Balance: $" + user.getBalance());
                        break;
                    case 5: // Exit
                        sessionActive = false;
                        break;
                    default:
                        System.out.println("Invalid operation number.");
                }
            } catch (Exception e) {
                System.out.println("Transaction Failed: " + e.getMessage());
            }

            // Check if user wants to continue (unless they already chose Exit)
            if (sessionActive) {
                sessionActive = askToContinue();
            }
        }
    }

    // --- Helper Methods (UI Logic) ---

    private static boolean askToContinue() {
        System.out.print("\nDo you want to continue? (Y/N): ");
        String input = sc.next();
        return input.equalsIgnoreCase("Y");
    }

    private static void printMenu() {
        System.out.println("\n--------------------------------");
        System.out.println("1. Details");
        System.out.println("2. Check Balance");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Exit");
        System.out.print("Select Operation: ");
    }

    // Input Validation Helpers
    private static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.next();
        }
        return sc.nextInt();
    }

    private static double getDoubleInput() {
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount.");
            sc.next();
        }
        return sc.nextDouble();
    }
}