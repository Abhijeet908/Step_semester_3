package polymorphism.assigment_problems;

import java.util.*;

public class CampusParkingChargeCalculator {
    static abstract class Vehicle {
        protected final int hours;
        Vehicle(int hours) { this.hours = hours; }
        abstract double charge();
    }
    static class Bike extends Vehicle {
        Bike(int hours) { super(hours); }
        double charge() { return hours * 10.0; }
    }
    static class Car extends Vehicle {
        Car(int hours) { super(hours); }
        double charge() { return hours == 1 ? 30.0 : 30.0 + (hours - 1) * 20.0; }
    }
    static class Truck extends Vehicle {
        Truck(int hours) { super(hours); }
        double charge() { return Math.max(100.0, hours * 50.0); }
    }
    static Vehicle create(String type, int hours) {
        return switch (type) {
            case "BIKE" -> new Bike(hours);
            case "CAR" -> new Car(hours);
            case "TRUCK" -> new Truck(hours);
            default -> throw new IllegalArgumentException("Unknown vehicle type");
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            double charge = create(type, hours).charge();
            System.out.printf(Locale.US, "%s: %.2f%n", type, charge);
            total += charge;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}