package encapsulation.class_problems;

/**
 * Practice Problem 2: The Quiz Scorecard.
 * The raw answer array never leaves this class.
 */
public class Scorecard {
    private final boolean[] results;
    private int answersRecorded;

    public Scorecard(int questionCount) {
        if (questionCount < 0) {
            throw new IllegalArgumentException("Question count cannot be negative");
        }
        results = new boolean[questionCount];
        answersRecorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answersRecorded < results.length) {
            results[answersRecorded] = correct;
            answersRecorded++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}
