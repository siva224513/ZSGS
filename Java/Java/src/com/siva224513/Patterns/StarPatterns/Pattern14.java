package com.siva224513.Patterns.StarPatterns;

import java.util.Scanner;

public class Pattern14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = scan.nextInt();
        pattern14(n);
        
    }

    public static void pattern14(int n) {
        int space = 2 * n - 2;
        for (int i = 1; i <= 2 * n - 1; i++) {
            int ind = i > n ? 2 * n - i : i;

            for (int j = 1; j <= ind; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= ind; j++) {
                System.out.print("*");
            }

            System.out.println();
            if (i < n)
                space -= 2;
            else
                space += 2;
        }

    }
}
