package Assignment3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== Welcome to the Java Game Hub ====");
        System.out.println("1. Play Cricket ");
        System.out.println("2. Play 2048 ");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                CricketGame cricket = new CricketGame();
                cricket.startMatch();
                break;
            case 2:
                Game2048 game2048 = new Game2048();
                game2048.play();
                break;    
            default:
                System.out.println("Invalid choice! Exiting...");
        }

        sc.close();
    }
}
