package abstraction_interface.assigment_problems;

import java.util.*;

public class ParcelShippingDesk {
    static abstract class Parcel {
        protected final double weight;
        protected final double declaredValue;
        Parcel(double weight, double declaredValue) { this.weight = weight; this.declaredValue = declaredValue; }
        abstract double charge();
    }
    interface Insurable { double insurance(); }
    static class Standard extends Parcel {
        Standard(double w, double v) { super(w, v); }
        double charge() { return 40 + 10 * weight; }
    }
    static class Express extends Parcel implements Insurable {
        Express(double w, double v) { super(w, v); }
        double charge() { return 80 + 15 * weight; }
        public double insurance() { return 0.02 * declaredValue; }
    }
    static class Fragile extends Parcel implements Insurable {
        Fragile(double w, double v) { super(w, v); }
        double charge() { return 40 + 10 * weight + 50; }
        public double insurance() { return 0.02 * declaredValue; }
    }
    static Parcel create(String type, double w, double v) {
        return switch (type) {
            case "STANDARD" -> new Standard(w, v);
            case "EXPRESS" -> new Express(w, v);
            case "FRAGILE" -> new Fragile(w, v);
            default -> throw new IllegalArgumentException("Unknown parcel type");
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel parcel = create(type, weight, value);
            double charge = parcel.charge();
            double insurance = parcel instanceof Insurable insured ? insured.insurance() : 0.0;
            double total = charge + insurance;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}