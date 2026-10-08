package polymorphism.assigment_problems;

import java.util.*;

public class CanteenBillingCounter {
    static abstract class Customer {
        protected final double amount;
        Customer(double amount) { this.amount = amount; }
        abstract double finalAmount();
    }
    static class Student extends Customer {
        Student(double amount) { super(amount); }
        double finalAmount() { return amount * 0.90; }
    }
    static class Staff extends Customer {
        Staff(double amount) { super(amount); }
        double finalAmount() { return amount * 0.95; }
    }
    static class Guest extends Customer {
        Guest(double amount) { super(amount); }
        double finalAmount() { return amount + 10; }
    }
    static Customer createCustomer(String type, double amount) {
        return switch (type) {
            case "STUDENT" -> new Student(amount);
            case "STAFF" -> new Staff(amount);
            case "GUEST" -> new Guest(amount);
            default -> throw new IllegalArgumentException("Unknown customer type");
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            double finalAmount = createCustomer(type, amount).finalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}