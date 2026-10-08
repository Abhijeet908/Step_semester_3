package polymorphism.class_problems;

import java.util.*;

public class DeliveryFeeCalculator {
    interface DeliveryType {
        double calculateFee();
    }

    static class StandardDelivery implements DeliveryType {
        private final double weight, distance;
        StandardDelivery(double weight, double distance) { this.weight = weight; this.distance = distance; }
        public double calculateFee() { return 5 + 0.50 * weight + 0.10 * distance; }
    }
    static class ExpressDelivery implements DeliveryType {
        private final double weight, distance;
        ExpressDelivery(double weight, double distance) { this.weight = weight; this.distance = distance; }
        public double calculateFee() { return 15 + weight + 0.20 * distance; }
    }
    static class InternationalDelivery implements DeliveryType {
        private final double weight, distance, customsFee;
        InternationalDelivery(double weight, double distance, double customsFee) {
            this.weight = weight; this.distance = distance; this.customsFee = customsFee;
        }
        public double calculateFee() { return 25 + 2 * weight + 0.50 * distance + customsFee; }
    }

    static DeliveryType create(String type, double weight, double distance, double customs) {
        return switch (type) {
            case "STANDARD" -> new StandardDelivery(weight, distance);
            case "EXPRESS" -> new ExpressDelivery(weight, distance);
            case "INTERNATIONAL" -> new InternationalDelivery(weight, distance, customs);
            default -> throw new IllegalArgumentException("Unknown delivery type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double customs = type.equals("INTERNATIONAL") ? sc.nextDouble() : 0;
            double fee = create(type, weight, distance, customs).calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", type, fee);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}