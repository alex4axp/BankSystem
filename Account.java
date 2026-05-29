
package banksystem;

public class Account {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account() {
        accountNumber = "00000000";
        ownerName = "Unknown";
        balance = 0.0;
    }

    public Account(String accountNumber, String ownerName, double balance) {
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);
        setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {

        if (accountNumber.matches("\\d{8,16}")) {
            this.accountNumber = accountNumber;
        } else {
            throw new IllegalArgumentException("Invalid account number.");
        }
    }

    public void setOwnerName(String ownerName) {

        if (ownerName.matches("[a-zA-Zأ-ي\\s]+")) {
            this.ownerName = ownerName;
        } else {
            throw new IllegalArgumentException("Invalid owner name.");
        }
    }

    public void setBalance(double balance) {

        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
    }

    public void deposit(double amount) {

        if (validateAmount(amount)) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    private boolean validateAmount(double amount) {
        
        return amount > 0;
    }
    public void withdraw(double amount) {

    if (amount <= 0) {

        System.out.println("Invalid amount!");

    } else if (amount > balance) {

        System.out.println("Insufficient balance!");

    } else {

        balance -= amount;

        System.out.printf("Withdraw successful! New balance: $%.2f%n", balance);
    }
}
    public void transfer(Account targetAccount, double amount) {

    double transferFee = 1.5;

    double totalAmount = amount + transferFee;

    if (amount <= 0) {

        System.out.println("Invalid transfer amount!");

    } else if (totalAmount > balance) {

        System.out.println("Insufficient balance for transfer!");

    } else {

        balance -= totalAmount;

        targetAccount.balance += amount;

        System.out.printf("Transfer successful!%n");
        System.out.printf("Transferred Amount: $%.2f%n", amount);
        System.out.printf("Transfer Fee: $%.2f%n", transferFee);
        System.out.printf("Your New Balance: $%.2f%n", balance);
    }
}

    @Override
    public String toString() {

        return "Account Number: " + accountNumber +
               " | Owner: " + ownerName +
               " | Balance: $" + balance;
    }
}