package abstraction_interface.assigment_problems;

import java.util.*;

public class CityCabFareMeter {
    static abstract class Cab {
        protected final double km;
        protected static final double MIN_FARE = 100.0;
        Cab(double km) { this.km = km; }
        abstract double rate();
        abstract boolean nightService();
        final double fare(boolean night) {
            double fare = Math.max(MIN_FARE, km * rate());
            return night ? fare * 1.20 : fare;
        }
    }
    static class Mini extends Cab { Mini(double km) { super(km); } double rate() { return 10; } boolean nightService() { return false; } }
    static class Sedan extends Cab { Sedan(double km) { super(km); } double rate() { return 14; } boolean nightService() { return true; } }
    static class SUV extends Cab { SUV(double km) { super(km); } double rate() { return 18; } boolean nightService() { return true; } }
    static Cab create(String type, double km) {
        return switch (type) {
            case "MINI" -> new Mini(km);
            case "SEDAN" -> new Sedan(km);
            case "SUV" -> new SUV(km);
            default -> throw new IllegalArgumentException("Unknown cab type");
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab = create(type, km);
            boolean night = time.equals("NIGHT");
            if (night && !cab.nightService()) {
                System.out.println(type + ": night service not available");
                continue;
            }
            double fare = cab.fare(night);
            System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}