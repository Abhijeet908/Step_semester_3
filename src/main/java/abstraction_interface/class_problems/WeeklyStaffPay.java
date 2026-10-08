package abstraction_interface.class_problems;

import java.util.*;

public class WeeklyStaffPay {
    static abstract class Staff {
        private final String name;
        Staff(String name) { this.name = name; }
        public String getName() { return name; }
        public abstract double pay();
    }

    static class FullTimeStaff extends Staff {
        private final double weeklySalary;
        FullTimeStaff(String name, double weeklySalary) { super(name); this.weeklySalary = weeklySalary; }
        public double pay() { return weeklySalary; }
    }
    static class HourlyStaff extends Staff {
        private final double hours, rate;
        HourlyStaff(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
        public double pay() {
            if (hours <= 40) return hours * rate;
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }
    static class Intern extends Staff {
        private final double stipend;
        Intern(String name, double stipend) { super(name); this.stipend = stipend; }
        public double pay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff staff;
            if (type.equals("FULLTIME")) staff = new FullTimeStaff(name, sc.nextDouble());
            else if (type.equals("HOURLY")) staff = new HourlyStaff(name, sc.nextDouble(), sc.nextDouble());
            else if (type.equals("INTERN")) staff = new Intern(name, sc.nextDouble());
            else throw new IllegalArgumentException("Unknown staff type: " + type);
            double pay = staff.pay();
            total += pay;
            System.out.printf("%s: %.2f%n", staff.getName(), pay);
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}