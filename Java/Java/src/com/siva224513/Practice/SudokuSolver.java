package com.siva224513.Practice;

import java.util.Scanner;

public class SudokuSolver {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SudokuSolver s = new SudokuSolver();
        // int matrix[][] = new int[9][9];
        // System.out.println("Enter array elements between 1 to 9");
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix[0].length; j++) {
        // matrix[i][j] = scan.nextInt();
        // }
        // }
        int[][] matrix = {
                { 8, 7, 6, 5, 4, 3, 0, 9, 0 },
                { 5, 4, 3, 2, 1, 0, 7, 6, 8 },
                { 2, 1, 9, 0, 7, 6, 4, 3, 5 },
                { 1, 0, 0, 0, 0, 5, 3, 2, 4 },
                { 4, 3, 2, 1, 9, 8, 6, 5, 7 },
                { 7, 0, 5, 4, 0, 2, 9, 8, 1 },
                { 3, 0, 1, 9, 8, 7, 5, 4, 6 },
                { 6, 0, 4, 3, 2, 1, 8, 7, 9 },
                { 9, 8, 7, 6, 5, 4, 2, 1, 3 } };

        if (s.solveSudoku(matrix)) {
            s.printMatrix(matrix);
        } else {
            System.out.println("No empty space already solved!!!");
        }
        // s.printMatrix();
    }

    private boolean solveSudoku(int puzzle[][]) {
        int coordinates[] = new int[2];
        int row = 0, col = 0;
        if (isEmptyCell(coordinates, puzzle)) {
            row = coordinates[0];
            col = coordinates[1];
        } else {
            return true;
        }

        System.out.println(row + " " + col + " ");
        for (int i = 1; i <= 9; i++) {
            if (isValid(row, col, i, puzzle)) {
                puzzle[row][col] = i;

                if (solveSudoku(puzzle)) {
                    return true;
                }
                puzzle[row][col] = 0;

            }
        }
        return false;

    }

    private boolean isValid(int row, int col, int num, int puzzle[][]) {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                if ((puzzle[row][j] == num) || (puzzle[j][col] == num)) {
                    return false;
                }
            }
        }
        int rowStart = row - row % 3;
        int colStart = col - col % 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (puzzle[i][j] == num) {
                    return false;
                }

            }
        }
        return true;

    }

    private boolean isEmptyCell(int[] coordinates, int puzzle[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (puzzle[i][j] == 0) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                    return true;
                }
            }
        }

        return false;
    }

    private void printMatrix(int puzzle[][]) {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
