package Programs;

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int k = 1;

        

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
