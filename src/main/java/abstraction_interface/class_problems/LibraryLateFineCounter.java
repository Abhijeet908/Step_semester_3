package abstraction_interface.class_problems;

import java.util.*;

public class LibraryLateFineCounter {
    static abstract class LibraryItem {
        private final String title;
        private final int daysLate;
        LibraryItem(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
        public String getTitle() { return title; }
        protected int getDaysLate() { return daysLate; }
        public abstract double fine();
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) { super(title, daysLate); }
        public double fine() { return 2.0 * getDaysLate(); }
    }
    static class DVD extends LibraryItem {
        DVD(String title, int daysLate) { super(title, daysLate); }
        public double fine() { return Math.min(5.0 * getDaysLate(), 50.0); }
    }
    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) { super(title, daysLate); }
        public double fine() { return getDaysLate(); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            LibraryItem item = switch (type) {
                case "BOOK" -> new Book(title, daysLate);
                case "DVD" -> new DVD(title, daysLate);
                case "MAGAZINE" -> new Magazine(title, daysLate);
                default -> throw new IllegalArgumentException("Unknown item type: " + type);
            };
            double fine = item.fine();
            total += fine;
            System.out.printf("%s: %.2f%n", item.getTitle(), fine);
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}