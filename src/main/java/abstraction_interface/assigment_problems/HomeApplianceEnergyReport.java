package abstraction_interface.assigment_problems;

import java.util.*;

public class HomeApplianceEnergyReport {
    interface SaverMode { }
    static abstract class Appliance {
        protected final double hours;
        Appliance(double hours) { this.hours = hours; }
        abstract double powerWatts();
        double units() { return powerWatts() * hours / 1000.0; }
        double cost() { return units() * 8.0; }
    }
    static class Fridge extends Appliance { Fridge(double h) { super(h); } double powerWatts() { return 150; } }
    static class AC extends Appliance implements SaverMode {
        AC(double h) { super(h); }
        double powerWatts() { return 1500; }
        double units() { return super.units() * 0.75; }
    }
    static class TV extends Appliance { TV(double h) { super(h); } double powerWatts() { return 100; } }
    static class Washer extends Appliance implements SaverMode {
        Washer(double h) { super(h); }
        double powerWatts() { return 500; }
        double units() { return super.units() * 0.75; }
    }
    static Appliance create(String type, double hours) {
        return switch (type) {
            case "FRIDGE" -> new Fridge(hours);
            case "AC" -> new AC(hours);
            case "TV" -> new TV(hours);
            case "WASHER" -> new Washer(hours);
            default -> throw new IllegalArgumentException("Unknown appliance type");
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saverRequested = sc.hasNext("SAVER");
            if (saverRequested) sc.next();
            Appliance appliance = create(type, hours);
            if (saverRequested && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }
            double units = appliance.units();
            double cost = appliance.cost();
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            totalCost += cost;
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}