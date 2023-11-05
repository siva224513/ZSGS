package com.siva224513.Patterns.StarPatterns;

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = scan.nextInt();
        pattern7(n);
        
    }

    public static void pattern7(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || j == i || j == 2 * n - i - 2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
