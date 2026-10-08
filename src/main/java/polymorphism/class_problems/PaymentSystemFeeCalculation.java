package polymorphism.class_problems;

import java.util.*;

public class PaymentSystemFeeCalculation {
    interface PaymentMethod {
        double adjustedAmount(double amount);
    }

    static class CardPayment implements PaymentMethod {
        public double adjustedAmount(double amount) { return amount * 1.02; }
    }
    static class WalletPayment implements PaymentMethod {
        public double adjustedAmount(double amount) { return amount * 1.01; }
    }
    static class BankTransfer implements PaymentMethod {
        public double adjustedAmount(double amount) { return amount; }
    }

    static PaymentMethod methodFor(String type) {
        return switch (type) {
            case "CARD" -> new CardPayment();
            case "WALLET" -> new WalletPayment();
            case "BANKTRANSFER" -> new BankTransfer();
            default -> throw new IllegalArgumentException("Unknown payment type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            double adjusted = methodFor(type).adjustedAmount(amount);
            total += adjusted;
            System.out.printf("%s: %.2f%n", type, adjusted);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}