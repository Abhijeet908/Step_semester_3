import java.util.Arrays;
import java.util.Scanner;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }

        public String getName() {
            return name;
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player player : players) {
            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(player.matchesPlayed, player.injured)) {
                draftable[count++] = player;
            }
        }

        Player[] shortlisted = Arrays.copyOf(draftable, count);
        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(shortlisted[i].getName());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for player " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Matches played: ");
            int matchesPlayed = sc.nextInt();
            System.out.print("Batting average: ");
            double battingAverage = sc.nextDouble();
            System.out.print("Injured (true/false): ");
            boolean injured = sc.nextBoolean();
            sc.nextLine();

            players[i] = new Player(name, matchesPlayed, battingAverage, injured);
        }

        System.out.println(draftAndRank(players));
        sc.close();
    }
}
