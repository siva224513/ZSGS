package Programs;

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int k = 1;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j <= n - 1 - i; j++) {
                arr[j][i] = k++;
            }
            for (int j = i + 1; j <= n - 1 - i; j++) {
                arr[n - 1 - i][j] = k++;
            }
            for (int j = n - 2 - i; j >= i; j--) {
                arr[j][n - 1 - i] = k++;
            }
            for (int j = n - 2 - i; j >= i + 1; j--) {
                arr[i][j] = k++;
            }
        }

        for (int i = 0; i< n; i++) {
            for (int sp = 0; sp < i; sp++) {
                System.out.print("  ");
            }

            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0)
                    System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
