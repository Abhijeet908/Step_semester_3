package data_structures.assigment_problems;

import java.util.Scanner;

public class DutyRosterRotation {
    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        long k = sc.nextLong();

        String[] result = rotateRoster(names, k);
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(result[i]);
        }
        System.out.println("]");
        // O(n) time and O(n) extra space.
        // k % n avoids repeating full rotations when k is very large.
    }
}