import java.util.Scanner;

public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    private static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain;
        do {
            clearBoard();
            String currentPlayer = "X";
            boolean isGameOver = false;
            int moveCounter = 0;

            while (!isGameOver) {
                displayBoard();
                System.out.println(currentPlayer + "'s turn. Enter your move:");

                int row = SafeInput.getRangedInt(console, "Enter row (1-3): ", 1, 3) - 1;
                int col = SafeInput.getRangedInt(console, "Enter column (1-3): ", 1, 3) - 1;

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    moveCounter++;

                    if (moveCounter >= 5 && isWin(currentPlayer)) {
                        displayBoard();
                        System.out.println(currentPlayer + " wins!");
                        isGameOver = true;
                    } else if (moveCounter == ROWS * COLS && isTie()) {
                        displayBoard();
                        System.out.println("It's a tie!");
                        isGameOver = true;
                    } else {
                        currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                    }
                } else {
                    System.out.println("Invalid move, try again.");
                }
            }
            playAgain = SafeInput.getYNConfirm(console, "Do you want to play again? (Y/N): ");
        } while (playAgain);
    }

    private static void clearBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void displayBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + (j < COLS - 1 ? "|" : ""));
            }
            System.out.println();
            if (i < ROWS - 1) {
                System.out.println("-----");
            }
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int i = 0; i < COLS; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
