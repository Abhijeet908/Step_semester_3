package encapsulation.class_problems;

/**
 * Practice Problem 1: The Piggy Bank.
 * Savings can only be changed through deposit() and withdraw().
 */
public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > savings) {
            return false;
        }
        savings -= amount;
        return true;
    }

    public String getId() {
        return id;
    }

    public double getSavings() {
        return savings;
    }
}
