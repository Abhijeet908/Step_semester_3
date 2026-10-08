package abstraction_interface.assigment_problems;

import java.util.*;

public class CollegeFeeCounter {
    static abstract class Student {
        protected final String name;
        protected static final double TRANSPORT_FEE = 12000.0;
        Student(String name) { this.name = name; }
        abstract double tuition();
        abstract boolean usesBus();
        final double totalFee() { return tuition() + (usesBus() ? TRANSPORT_FEE : 0); }
    }
    static class DayScholar extends Student {
        DayScholar(String name) { super(name); }
        double tuition() { return 40000; }
        boolean usesBus() { return true; }
    }
    static class Hosteller extends Student {
        Hosteller(String name) { super(name); }
        double tuition() { return 100000; }
        boolean usesBus() { return false; }
    }
    static class Scholar extends Student {
        Scholar(String name) { super(name); }
        double tuition() { return 20000; }
        boolean usesBus() { return true; }
    }
    static Student create(String type, String name) {
        return switch (type) {
            case "DAY_SCHOLAR" -> new DayScholar(name);
            case "HOSTELLER" -> new Hosteller(name);
            case "SCHOLAR" -> new Scholar(name);
            default -> throw new IllegalArgumentException("Unknown student type");
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student = create(type, name);
            double fee = student.totalFee();
            System.out.printf(Locale.US, "%s: %.2f%n", name, fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}