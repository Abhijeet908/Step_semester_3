package polymorphism.class_problems;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;

public class LibraryItemDueDateCalculator {
    static abstract class LibraryItem {
        private final String title;
        protected LibraryItem(String title) { this.title = title; }
        public String getTitle() { return title; }
        protected abstract int borrowingDays();
        public LocalDate dueDate(LocalDate currentDate) { return currentDate.plusDays(borrowingDays()); }
    }

    static class Book extends LibraryItem {
        Book(String title) { super(title); }
        protected int borrowingDays() { return 14; }
    }
    static class DVD extends LibraryItem {
        DVD(String title) { super(title); }
        protected int borrowingDays() { return 7; }
    }
    static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        protected int borrowingDays() { return 3; }
    }

    static String[] tokens(String line) {
        Matcher m = Pattern.compile("\"([^\"]*)\"|(\S+)").matcher(line);
        List<String> result = new ArrayList<>();
        while (m.find()) result.add(m.group(1) != null ? m.group(1) : m.group(2));
        return result.toArray(new String[0]);
    }

    static LibraryItem create(String type, String title) {
        return switch (type) {
            case "BOOK" -> new Book(title);
            case "DVD" -> new DVD(title);
            case "MAGAZINE" -> new Magazine(title);
            default -> throw new IllegalArgumentException("Unknown item type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] t = tokens(line);
            LibraryItem item = create(t[0], t[1]);
            System.out.println(item.getTitle() + ": " + item.dueDate(currentDate));
        }
    }
}