package org.example;

import java.util.Scanner;

public class NQueens {

    public static void printBoard(int[][] board) {
        System.out.println("\nN-Queens Board:");
        for (int[] row : board) {
            for (int cell : row)
                System.out.print((cell == 1 ? " Q " : " . "));
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    public static boolean solveNQueens(int[][] board, int row, int n) {
        if (row == n)
            return true;

        for (int col = 0; col < n; col++) {
            if (board[row][col] == 1) {
                if (!isSafe(board, row, col, n))
                    return false;
                if (solveNQueens(board, row + 1, n))
                    return true;
                return false;
            }
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                if (solveNQueens(board, row + 1, n))
                    return true;
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter board size n: ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        System.out.println("Enter first queen position (0-indexed):");
        System.out.print("Row: ");
        int firstRow = sc.nextInt();
        System.out.print("Column: ");
        int firstCol = sc.nextInt();
        board[firstRow][firstCol] = 1;

        if (solveNQueens(board, 0, n))
            printBoard(board);
        else
            System.out.println("No solution exists with the first queen at (" + firstRow + ", " + firstCol + ")");

        sc.close();
    }
}

/*
TC : O(N!)
SC : O(N^2)
 */
