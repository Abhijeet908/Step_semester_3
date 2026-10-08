package abstraction_interface.class_problems;

import java.util.*;

public class ElectricityConnectionBilling {
    static abstract class Connection {
        protected final int units;
        Connection(int units) { this.units = units; }
        public abstract double bill();
    }

    static class Home extends Connection {
        Home(int units) { super(units); }
        public double bill() { return Math.min(units, 100) * 5.0 + Math.max(0, units - 100) * 7.0; }
    }
    static class Shop extends Connection {
        Shop(int units) { super(units); }
        public double bill() { return units * 8.0 + 100; }
    }
    static class Factory extends Connection {
        Factory(int units) { super(units); }
        public double bill() { return Math.max(1000.0, units * 6.0); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection connection = switch (type) {
                case "HOME" -> new Home(units);
                case "SHOP" -> new Shop(units);
                case "FACTORY" -> new Factory(units);
                default -> throw new IllegalArgumentException("Unknown connection type: " + type);
            };
            double bill = connection.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", type, bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}