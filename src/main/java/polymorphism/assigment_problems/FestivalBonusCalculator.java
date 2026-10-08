package polymorphism.assigment_problems;

import java.util.*;

public class FestivalBonusCalculator {
    static abstract class Employee {
        protected final String name;
        protected final double salary;
        Employee(String name, double salary) { this.name = name; this.salary = salary; }
        abstract double bonus();
    }
    static class FullTime extends Employee {
        FullTime(String name, double salary) { super(name, salary); }
        double bonus() { return salary * 0.10; }
    }
    static class PartTime extends Employee {
        PartTime(String name, double salary) { super(name, salary); }
        double bonus() { return salary * 0.05; }
    }
    static class Intern extends Employee {
        Intern(String name, double salary) { super(name, salary); }
        double bonus() { return 2000.0; }
    }
    static Employee create(String type, String name, double salary) {
        return switch (type) {
            case "FULLTIME" -> new FullTime(name, salary);
            case "PARTTIME" -> new PartTime(name, salary);
            case "INTERN" -> new Intern(name, salary);
            default -> throw new IllegalArgumentException("Unknown employee type");
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            Employee employee = create(type, name, salary);
            double bonus = employee.bonus();
            System.out.printf(Locale.US, "%s: %.2f%n", name, bonus);
            total += bonus;
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}