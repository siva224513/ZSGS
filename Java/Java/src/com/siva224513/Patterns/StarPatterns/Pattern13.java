package com.siva224513.Patterns.StarPatterns;

import java.util.Scanner;

public class Pattern13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = scan.nextInt();
        pattern13(n);
        
    }

    public static void pattern13(int n) {
        int end = 2 * n - 2;
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if (i == 0 || i == 2 * n - 2) {
                    if (j % 2 == 0) {
                        System.out.print("*");

                    } else {
                        System.out.print(" ");
                    }
                } else if (j == i || end == j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            end--;
        }
    }
}
