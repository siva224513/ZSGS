package com.siva224513.Array;


import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the dimensions of the first matrix
        System.out.print("Enter the number of rows for the 1st matrix: ");
        int m1 = scanner.nextInt();
        System.out.print("Enter the number of columns for the 1st matrix: ");
        int n1 = scanner.nextInt();

        // Input the dimensions of the second matrix
        System.out.print("Enter the number of rows for the 2nd matrix: ");
        int m2 = scanner.nextInt();
        System.out.print("Enter the number of columns for the 2nd matrix: ");
        int n2 = scanner.nextInt();

        if (n1 != m2) {
            System.out.println("Matrix multiplication is not possible. The number of columns in the first matrix must be equal to the number of rows in the second matrix.");
        } else {
            
            int[][] matrix1 = new int[m1][n1];
            int[][] matrix2 = new int[m2][n2];
            int[][] result = new int[m1][n2];

            
            System.out.println("Enter the elements of the 1st matrix:");
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n1; j++) {
                    matrix1[i][j] = scanner.nextInt();
                }
            }

            
            System.out.println("Enter the elements of the 2nd matrix:");
            for (int i = 0; i < m2; i++) {
                for (int j = 0; j < n2; j++) {
                    matrix2[i][j] = scanner.nextInt();
                }
            }
             
            System.out.println("First Matrix:");
            printMatrix(matrix1,m1,n1);
            System.out.println("Second Matrix:");
            printMatrix(matrix2,m2,n2);

            // matrix multiplication
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                    for (int k = 0; k < n1; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

            
            System.out.println("Matrix Multiplication Result:");
            printMatrix(result, m1, n2);
        }

        
    }
    public static void printMatrix(int matrix[][],int row,int col){
        for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
    }
}
