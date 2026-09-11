package week1classproblems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};

        int n = 5;
        int wins = 0, losses = 0, draws = 0;

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            playerMoves[i] = sc.next();
            computerMoves[i] = moves[random.nextInt(3)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("\nRound\tPlayer\t\tComputer\tResult");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + playerMoves[i] + "\t\t" + computerMoves[i] + "\t\t" + results[i]);
        }

        double winPercentage = ((double) wins / n) * 100;
        System.out.println("\nWins: " + wins + " | Losses: " + losses + " | Draws: " + draws
                + " | Win % = " + String.format("%.1f", winPercentage) + "%");

        sc.close();
    }
}
