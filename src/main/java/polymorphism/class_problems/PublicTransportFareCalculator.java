package polymorphism.class_problems;

import java.util.*;

public class PublicTransportFareCalculator {
    interface Transport {
        double fare();
    }

    static class Bus implements Transport {
        private final double distance;
        Bus(double distance) { this.distance = distance; }
        public double fare() { return Math.min(2 + 0.10 * distance, 10); }
    }
    static class Train implements Transport {
        private final double distance;
        Train(double distance) { this.distance = distance; }
        public double fare() { return 3 + 0.15 * distance; }
    }
    static class Metro implements Transport {
        private final double distance, peakFactor;
        Metro(double distance, double peakFactor) { this.distance = distance; this.peakFactor = peakFactor; }
        public double fare() { return (1.50 + 0.20 * distance) * peakFactor; }
    }

    static Transport create(String type, double distance, double factor) {
        return switch (type) {
            case "BUS" -> new Bus(distance);
            case "TRAIN" -> new Train(distance);
            case "METRO" -> new Metro(distance, factor);
            default -> throw new IllegalArgumentException("Unknown transport type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            double factor = type.equals("METRO") ? sc.nextDouble() : 1;
            double fare = create(type, distance, factor).fare();
            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}