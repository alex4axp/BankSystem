
package banksystem;

public class SavingsAccount extends Account {

    private double interestRate;
    private double minimumBalance;

    public SavingsAccount() {
        super();
        interestRate = 0.0;
        minimumBalance = 0.0;
    }

    public SavingsAccount(String accountNumber, String ownerName,
                          double balance, double interestRate,
                          double minimumBalance) {

        super(accountNumber, ownerName, balance);

        setInterestRate(interestRate);
        setMinimumBalance(minimumBalance);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setInterestRate(double interestRate) {

        if (interestRate >= 0 && interestRate <= 100) {
            this.interestRate = interestRate;
        } else {
            throw new IllegalArgumentException("Invalid interest rate.");
        }
    }

    public void setMinimumBalance(double minimumBalance) {

        if (minimumBalance >= 0) {
            this.minimumBalance = minimumBalance;
        } else {
            throw new IllegalArgumentException("Invalid minimum balance.");
        }
    }

    public double calculateInterest() {

        double interest = getBalance() * interestRate / 100;

        System.out.println("Interest calculated: $" + interest);

        return interest;
    }

    public void applyInterest() {

        double interest = calculateInterest();

        setBalance(getBalance() + interest);
    }

    @Override
    public String toString() {

        return super.toString() +
               " | Interest Rate: " + interestRate +
               "% | Minimum Balance: $" + minimumBalance;
    }
}