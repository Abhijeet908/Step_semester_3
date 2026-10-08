package polymorphism.class_problems;

import java.util.*;
import java.util.regex.*;

public class ExaminationQuestionGrader {
    static abstract class Question {
        protected final String type, questionText, correctAnswer;
        protected final double points;
        Question(String type, String questionText, String correctAnswer, double points) {
            this.type = type; this.questionText = questionText; this.correctAnswer = correctAnswer; this.points = points;
        }
        abstract double score(String studentAnswer);
    }

    static class MCQ extends Question {
        MCQ(String q, String a, double p) { super("MCQ", q, a, p); }
        double score(String studentAnswer) { return studentAnswer.equals(correctAnswer) ? points : 0; }
    }
    static class TrueFalse extends Question {
        TrueFalse(String q, String a, double p) { super("TF", q, a, p); }
        double score(String studentAnswer) { return studentAnswer.equals(correctAnswer) ? points : 0; }
    }
    static class Essay extends Question {
        Essay(String q, String a, double p) { super("ESSAY", q, a, p); }
        double score(String studentAnswer) {
            String answer = studentAnswer.toLowerCase(Locale.ROOT);
            int matches = 0;
            for (String keyword : correctAnswer.split(",")) {
                String k = keyword.trim().toLowerCase(Locale.ROOT);
                if (!k.isEmpty() && answer.contains(k)) matches++;
            }
            if (matches >= 2) return points * 0.75;
            if (matches == 1) return points * 0.50;
            return 0;
        }
    }

    static String[] tokens(String line) {
        Matcher m = Pattern.compile("\"([^\"]*)\"|(\S+)").matcher(line);
        List<String> result = new ArrayList<>();
        while (m.find()) result.add(m.group(1) != null ? m.group(1) : m.group(2));
        return result.toArray(new String[0]);
    }

    static Question create(String[] t) {
        String type = t[0];
        String questionText = t[1];
        String correct = t[2];
        String student = t[3];
        double points = Double.parseDouble(t[4]);
        return switch (type) {
            case "MCQ" -> new MCQ(questionText, correct, points) {
                @Override double score(String ignored) { return student.equals(correctAnswer) ? this.points : 0; }
            };
            case "TF" -> new TrueFalse(questionText, correct, points) {
                @Override double score(String ignored) { return student.equals(correctAnswer) ? this.points : 0; }
            };
            case "ESSAY" -> new Essay(questionText, correct, points);
            default -> throw new IllegalArgumentException("Unknown question type: " + type);
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String line;
            do { line = sc.nextLine().trim(); } while (line.isEmpty());
            String[] t = tokens(line);
            Question question = create(t);
            double score = question.score(t[3]);
            total += score;
            System.out.printf("%s: %.2f%n", t[0], score);
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}