package polymorphism.assigment_problems;

import java.time.LocalDate;
import java.util.*;

public class StreamingPlanRenewalReminder {
    static abstract class Plan {
        protected final String name;
        protected final LocalDate startDate;
        Plan(String name, LocalDate startDate) { this.name = name; this.startDate = startDate; }
        abstract int validityDays();
        LocalDate renewalDate() { return startDate.plusDays(validityDays()); }
    }
    static class Basic extends Plan {
        Basic(String name, LocalDate date) { super(name, date); }
        int validityDays() { return 30; }
    }
    static class Standard extends Plan {
        Standard(String name, LocalDate date) { super(name, date); }
        int validityDays() { return 90; }
    }
    static class Premium extends Plan {
        Premium(String name, LocalDate date) { super(name, date); }
        int validityDays() { return 365; }
    }
    static Plan create(String type, String name, LocalDate date) {
        return switch (type) {
            case "BASIC" -> new Basic(name, date);
            case "STANDARD" -> new Standard(name, date);
            case "PREMIUM" -> new Premium(name, date);
            default -> throw new IllegalArgumentException("Unknown plan type");
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            Plan plan = create(type, name, date);
            System.out.println(name + ": " + plan.renewalDate());
        }
    }
}