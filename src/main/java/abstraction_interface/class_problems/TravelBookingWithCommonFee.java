package abstraction_interface.class_problems;

import java.util.*;

public class TravelBookingWithCommonFee {
    static abstract class Booking {
        protected static final double BOOKING_FEE = 50.0;
        protected final double distance;
        Booking(double distance) { this.distance = distance; }
        protected abstract double baseFare();
        public final double totalFare() { return baseFare() + BOOKING_FEE; }
    }

    static class BusBooking extends Booking {
        BusBooking(double distance) { super(distance); }
        protected double baseFare() { return 2.0 * distance; }
    }
    static class TrainBooking extends Booking {
        TrainBooking(double distance) { super(distance); }
        protected double baseFare() { return 1.5 * distance; }
    }
    static class FlightBooking extends Booking {
        FlightBooking(double distance) { super(distance); }
        protected double baseFare() { return 2500.0 + 4.0 * distance; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking booking = switch (mode) {
                case "BUS" -> new BusBooking(distance);
                case "TRAIN" -> new TrainBooking(distance);
                case "FLIGHT" -> new FlightBooking(distance);
                default -> throw new IllegalArgumentException("Unknown travel mode: " + mode);
            };
            System.out.printf("%s: %.2f%n", mode, booking.totalFare());
        }
    }
}