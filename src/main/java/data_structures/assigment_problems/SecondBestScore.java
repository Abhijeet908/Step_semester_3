package data_structures.assigment_problems;

import java.util.Scanner;

public class SecondBestScore {
    static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.println(secondHighest(scores));
        // One pass: O(n) time and O(1) extra space.
        // Sorting would take O(n log n) time.
    }
}