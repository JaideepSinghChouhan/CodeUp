package Assignment3;
import java.util.*;

public class CricketGame {
    private int overs;
    private int totalRuns = 0;
    private int wickets = 0;
    private Random random = new Random();
    private Scanner sc = new Scanner(System.in);

    public void startMatch() {
        System.out.println("==== Welcome to Console Cricket! ====");
        System.out.print("Enter number of overs: ");
        overs = sc.nextInt();

        System.out.println("You are batting first!");
        int balls = overs * 6;

        for (int i = 1; i <= balls; i++) {
            System.out.print("Press Enter to play ball...");
            sc.nextLine(); // wait for user input
            int outcome = random.nextInt(8); // 0–7 (7 = wicket)

            if (outcome == 7) {
                wickets++;
                System.out.println("Oh no! You are OUT! Wickets: " + wickets);
                if (wickets == 2) { // two wickets = all out for simplicity
                    System.out.println("All out! Final Score: " + totalRuns);
                    break;
                }
            } else {
                totalRuns += outcome;
                System.out.println("You scored " + outcome + " runs.");
                System.out.println("Total Runs: " + totalRuns + ", Wickets: " + wickets);
                System.out.println("Overs : " + (i / 6) + "." + (i % 6));
                System.out.println("-----------------------------");
            }
        }

        System.out.println("\nYour innings ended with " + totalRuns + " runs.");
        System.out.println("Opponent is chasing " + (totalRuns + 1) + " runs...\n");
        simulateOpponent();
    }

    private void simulateOpponent() {
        int opponentRuns = 0;
        int opponentWickets = 0;
        int balls = overs * 6;

        for (int i = 1; i <= balls; i++) {
            int outcome = random.nextInt(8);
            if (outcome == 7) {
                opponentWickets++;
                if (opponentWickets == 2) {
                    System.out.println("Opponent all out! Scored: " + opponentRuns);
                    break;
                }
            } else {
                opponentRuns += outcome;
            }

            if (opponentRuns > totalRuns) {
                System.out.println("Opponent chased the target! with " + opponentRuns + " runs. You lost by " + (2 - opponentWickets) + " wickets.");
                return;
            }
        }

        if (opponentRuns < totalRuns) {
            System.out.println("You defended the target successfully!");
            System.out.println("Opponent managed to score: " + opponentRuns +" runs.");
            System.out.println("Wickets lost by opponent: " + opponentWickets);
            System.out.println("You won by " + (totalRuns - opponentRuns) + " runs!");
        } else if (opponentRuns == totalRuns) {
            System.out.println("Match tied!");
        }
    }
}
