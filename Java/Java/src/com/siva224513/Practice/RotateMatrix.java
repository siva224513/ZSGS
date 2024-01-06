
import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RotateMatrix r = new RotateMatrix();
        System.out.println("Enter the size of the n*n matrix");
        int n = scan.nextInt();
        System.out.println("Enter " + n * n + " elements");
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        System.out.println("Before rotation");
        r.printMatrix(matrix, n);
        r.rotateMatrix(matrix, n);
        System.out.println("After rotation");
        r.printMatrix(matrix, n);
    }

    private void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void rotateMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

    }
}
