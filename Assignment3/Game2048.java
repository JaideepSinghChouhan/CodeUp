/**
 * @filename-Game2048.java
 * @description-A console-based implementation of the 2048 game.
 * @author-JD
 */

package Assignment3;

import java.util.Random;
import java.util.Scanner;

public class Game2048 {
    private int[][] board = new int[4][4];
    private Random random = new Random();
    private Scanner sc = new Scanner(System.in);

    public void play() {
        System.out.println("==== Welcome to 2048 Console Edition 🎮 ====");
        addRandomTile();
        addRandomTile();
        printBoard();

        while (true) {
            System.out.print("Move (W/A/S/D or Q to quit): ");
            char move = sc.next().toUpperCase().charAt(0);

            if (move == 'Q') {
                System.out.println("Game exited!");
                break;
            }

            boolean moved = false;
            switch (move) {
                case 'W': moved = moveUp(); break;
                case 'S': moved = moveDown(); break;
                case 'A': moved = moveLeft(); break;
                case 'D': moved = moveRight(); break;
                default:
                    System.out.println("Invalid move! Use W/A/S/D keys.");
                    continue;
            }

            if (moved) {
                addRandomTile();
                printBoard();
            } else {
                System.out.println("No tiles moved, try another direction.");
            }

            if (checkWin()) {
                System.out.println("🎉 Congratulations! You reached 2048!");
                break;
            }

            if (isGameOver()) {
                System.out.println("😞 Game Over! No more valid moves.");
                break;
            }
        }
    }

    /** Add a random tile (2 or 4) to an empty cell */
    private void addRandomTile() {
        int emptyCount = 0;

        // Count empty cells
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (board[i][j] == 0)
                    emptyCount++;

        if (emptyCount == 0) return;

        // Select a random empty cell
        int pos = random.nextInt(emptyCount);
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    if (count == pos) {
                        board[i][j] = (random.nextInt(10) == 0) ? 4 : 2;
                        return;
                    }
                    count++;
                }
            }
        }
    }

    /** Print the board in console */
    private void printBoard() {
        System.out.println("---------------------");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0)
                    System.out.printf("%4s", ".");
                else
                    System.out.printf("%4d", board[i][j]);
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    /** Move tiles left */
    private boolean moveLeft() {
        boolean moved = false;
        for (int i = 0; i < 4; i++) {
            int[] newRow = new int[4];
            int index = 0;
            boolean merged = false;

            for (int j = 0; j < 4; j++) {
                int val = board[i][j];
                if (val != 0) {
                    if (index > 0 && newRow[index - 1] == val && !merged) {
                        newRow[index - 1] *= 2;
                        merged = true;
                        moved = true;
                    } else {
                        newRow[index++] = val;
                        merged = false;
                    }
                }
            }

            // check if board changed
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != newRow[j]) {
                    board[i][j] = newRow[j];
                    moved = true;
                }
            }
        }
        return moved;
    }

    /** Move right (reverse + moveLeft + reverse back) */
    private boolean moveRight() {
        reverseRows();
        boolean moved = moveLeft();
        reverseRows();
        return moved;
    }

    /** Move up (transpose + moveLeft + transpose back) */
    private boolean moveUp() {
        transpose();
        boolean moved = moveLeft();
        transpose();
        return moved;
    }

    /** Move down (transpose + moveRight + transpose back) */
    private boolean moveDown() {
        transpose();
        boolean moved = moveRight();
        transpose();
        return moved;
    }

    /** Helper: reverse each row */
    private void reverseRows() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0, k = 3; j < k; j++, k--) {
                int temp = board[i][j];
                board[i][j] = board[i][k];
                board[i][k] = temp;
            }
        }
    }

    /** Helper: transpose the board (for up/down moves) */
    private void transpose() {
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int temp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = temp;
            }
        }
    }

    /** Check for 2048 tile */
    private boolean checkWin() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (board[i][j] == 2048)
                    return true;
        return false;
    }

    /** Check if there are no valid moves */
    private boolean isGameOver() {
        // If any empty cell, not over
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (board[i][j] == 0)
                    return false;

        // Check for any possible merges horizontally or vertically
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == board[i][j + 1])
                    return false;

        for (int j = 0; j < 4; j++)
            for (int i = 0; i < 3; i++)
                if (board[i][j] == board[i + 1][j])
                    return false;

        return true;
    }
}

