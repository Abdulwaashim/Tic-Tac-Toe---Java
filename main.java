
import java.util.Scanner;

class main {
    public static void main(String[] args) {
        char[][] board = new char[3][3]; // creating 3 x 3 board.
        for (int row = 0; row < board.length; row ++){
            for (int col = 0; col<board[row].length; col++){
                board[row][col] = ' '; // Making it empty.
            }
        }

        char player = 'X';
        boolean gameOver = false;

        Scanner scanner = new Scanner(System.in);

        while (!gameOver){
            printBoard(board);
            System.out.println("Player " + player + " Enter : ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' '){
                board[row][col] = player; //place element
                gameOver = haveWon(board, player);
                if (gameOver){
                    System.out.println();
                    System.out.println("*---------------*");
                    System.out.println("Player " + player + " has Won");
                }else {
                    /*if (player == 'X'){
                        player == 'O';
                    }else {
                        player = 'X';
                    }*/

                   player = (player == 'X') ? 'O' : 'X';
                }

            }else{
                System.out.println("Invalid Move. Try again");
            }
        }

        printBoard(board);
        System.out.println("*---------------*");
    }

    public static boolean haveWon(char [][] board, char player) {

        //check the rows

        for (int row = 0; row < board.length; row ++){
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player)
            return true;
        }

        // check for col
        for (int col = 0; col < board.length; col ++){
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player)
            return true;
        }

        //diagnoall

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }

        return false;
    }

    public static void printBoard(char[][] board) {

        for (int row = 0; row < board.length; row ++){
            for (int col = 0; col<board[row].length; col++){
                System.out.print(" [" + board[row][col] + "] ");
            }
            System.out.println();
        }
    
    }
}




/*    Alternative :-

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = -1, col = -1;
            boolean validInput = false;
            while (!validInput) {
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt() - 1;
                    if (scanner.hasNextInt()) {
                        col = scanner.nextInt() - 1;
                        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                            validInput = true;
                        } else {
                            System.out.println("This move is not valid. Please enter row and column (1-3).");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter column (1-3).");
                        scanner.next(); // Clear the invalid input
                    }
                } else {
                    System.out.println("Invalid input. Please enter row and column (1-3).");
                    scanner.next(); // Clear the invalid input
                }
            }
            board[row][col] = currentPlayer;
            if (isWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("The game is a draw!");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        scanner.close();
    }

    private static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n---------");
        }
    }

    private static boolean isWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

*/

