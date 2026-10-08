package abstraction_interface.class_problems;

import java.util.*;

public class GardenPlotAreaReport {
    static abstract class Plot {
        private final String owner;
        Plot(String owner) { this.owner = owner; }
        public String getOwner() { return owner; }
        public abstract String getShape();
        public abstract double area();
    }

    static class Circle extends Plot {
        private final double radius;
        Circle(String owner, double radius) { super(owner); this.radius = radius; }
        public String getShape() { return "CIRCLE"; }
        public double area() { return Math.PI * radius * radius; }
    }
    static class Rectangle extends Plot {
        private final double length, width;
        Rectangle(String owner, double length, double width) { super(owner); this.length = length; this.width = width; }
        public String getShape() { return "RECTANGLE"; }
        public double area() { return length * width; }
    }
    static class Triangle extends Plot {
        private final double base, height;
        Triangle(String owner, double base, double height) { super(owner); this.base = base; this.height = height; }
        public String getShape() { return "TRIANGLE"; }
        public double area() { return 0.5 * base * height; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot plot;
            if (shape.equals("CIRCLE")) {
                plot = new Circle(owner, sc.nextDouble());
            } else if (shape.equals("RECTANGLE")) {
                plot = new Rectangle(owner, sc.nextDouble(), sc.nextDouble());
            } else if (shape.equals("TRIANGLE")) {
                plot = new Triangle(owner, sc.nextDouble(), sc.nextDouble());
            } else {
                throw new IllegalArgumentException("Unknown shape: " + shape);
            }
            double area = plot.area();
            total += area;
            System.out.printf("%s (%s): %.2f%n", plot.getOwner(), plot.getShape(), area);
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}