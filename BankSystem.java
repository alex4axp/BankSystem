
package banksystem;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {

    public static void main(String[] args) {

        ArrayList<SavingsAccount> accountsList = new ArrayList<>();

        accountsList = dataFill(accountsList);

        System.out.println("\n========================================");
        System.out.println("Accounts with balance greater than $1000");
        System.out.println("========================================");

        dataPrint(accountsList);
        
        
    }

    public static ArrayList<SavingsAccount> dataFill(ArrayList<SavingsAccount> accountsList) {

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {

            System.out.println("\n--- Enter details for Account " + i + " ---");

          

           String accountNumber;

while (true) {

    System.out.print("Account Number: ");
    accountNumber = scanner.nextLine();

    if (!accountNumber.matches("\\d{8,16}")) {
        System.out.println("Invalid account number format!");
        continue;
    }

    if (isAccountExists(accountsList, accountNumber)) {
        System.out.println("This account number already exists!");
        continue;
    }

    break;
}

            String ownerName;

            while (true) {

                System.out.print("Owner Name: ");
                ownerName = scanner.nextLine();

                if (ownerName.matches("[a-zA-Zأ-ي\\s]+")) {
                    break;
                } else {
                    System.out.println("Invalid owner name.");
                }
            }

            double balance;

            while (true) {

                System.out.print("Balance ($): ");

                if (scanner.hasNextDouble()) {

                    balance = scanner.nextDouble();

                    if (balance >= 0) {
                        break;
                    } else {
                        System.out.println("Balance cannot be negative.");
                    }

                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            }

            double interestRate;

            while (true) {

                System.out.print("Interest Rate (%): ");

                if (scanner.hasNextDouble()) {

                    interestRate = scanner.nextDouble();

                    if (interestRate >= 0 && interestRate <= 100) {
                        break;
                    } else {
                        System.out.println("Interest rate must be between 0 and 100.");
                    }

                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            }

            double minimumBalance;

            while (true) {

                System.out.print("Minimum Balance ($): ");

                if (scanner.hasNextDouble()) {

                    minimumBalance = scanner.nextDouble();

                    if (minimumBalance >= 0) {
                        break;
                    } else {
                        System.out.println("Minimum balance cannot be negative.");
                    }

                } else {
                    System.out.println("Invalid input.");
                    scanner.next();
                }
            }

            scanner.nextLine();

            SavingsAccount account =
                    new SavingsAccount(accountNumber, ownerName,
                            balance, interestRate, minimumBalance);

            accountsList.add(account);
        }

        System.out.println("\nAll accounts added successfully!");

        return accountsList;
    }

    public static void dataPrint(ArrayList<SavingsAccount> accountsList) {

        boolean found = false;

        for (SavingsAccount account : accountsList) {

            if (account.getBalance() > 1000) {

                System.out.println(account);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No accounts found.");
        }
        
        
        
    }
    
    public static boolean isAccountExists(ArrayList<SavingsAccount> accountsList, String accountNumber) {

    for (SavingsAccount acc : accountsList) {

        if (acc.getAccountNumber().equals(accountNumber)) {
            return true;
        }
    }

    return false;
}
    
    
    
}