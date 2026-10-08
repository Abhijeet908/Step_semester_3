package polymorphism.assigment_problems;

import java.util.*;

public class HostelElectricityBill {
    static abstract class Room {
        protected final int units;
        Room(int units) { this.units = units; }
        abstract double bill();
    }
    static class SingleRoom extends Room {
        SingleRoom(int units) { super(units); }
        double bill() { return units * 8.0; }
    }
    static class SharedRoom extends Room {
        private final int occupants;
        SharedRoom(int units, int occupants) { super(units); this.occupants = occupants; }
        double bill() { return units * 6.0 / occupants; }
    }
    static class AcRoom extends Room {
        AcRoom(int units) { super(units); }
        double bill() { return units * 10.0 + 200.0; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room room = switch (type) {
                case "SINGLE" -> new SingleRoom(units);
                case "SHARED" -> new SharedRoom(units, sc.nextInt());
                case "AC" -> new AcRoom(units);
                default -> throw new IllegalArgumentException("Unknown room type");
            };
            double bill = room.bill();
            System.out.printf(Locale.US, "%s: %.2f%n", type, bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}