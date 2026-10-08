package abstraction_interface.assigment_problems;

import java.util.*;

public class MovieTicketCounter {
    static abstract class Ticket {
        protected static final double CONVENIENCE_FEE = 20.0;
        protected final int count;
        Ticket(int count) { this.count = count; }
        abstract double pricePerTicket();
        final double amount() { return count * (pricePerTicket() + CONVENIENCE_FEE); }
    }
    static class Regular extends Ticket { Regular(int count) { super(count); } double pricePerTicket() { return 150; } }
    static class Premium extends Ticket { Premium(int count) { super(count); } double pricePerTicket() { return 250; } }
    static class Recliner extends Ticket { Recliner(int count) { super(count); } double pricePerTicket() { return 400; } }
    static Ticket create(String type, int count) {
        return switch (type) {
            case "REGULAR" -> new Regular(count);
            case "PREMIUM" -> new Premium(count);
            case "RECLINER" -> new Recliner(count);
            default -> throw new IllegalArgumentException("Unknown seat type");
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            double amount = create(type, count).amount();
            System.out.printf(Locale.US, "%s: %.2f%n", type, amount);
            total += amount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}