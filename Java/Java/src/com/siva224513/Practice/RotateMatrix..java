import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the matrix size");
        int size = scan.nextInt();
        int matrix[][] = new int[size][size];
        System.out.println("Enter matrix elements");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        RotateMatrix obj = new RotateMatrix();
        obj.transpose(matrix);
        obj.printMatrix(matrix);
    }

    private void transpose(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println();
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
