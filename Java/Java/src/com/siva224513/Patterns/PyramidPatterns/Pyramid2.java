package com.siva224513.Patterns.PyramidPatterns;

import java.util.Scanner;

public class Pyramid2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = scan.nextInt();
        pyramid2(n);
       
    }

    public static void pyramid2(int n) {
        for (int i = n; i >= 1; i--) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }

            System.out.println();

        }
    }
}
