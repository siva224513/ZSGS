package com.siva224513.Patterns.StarPatterns;

import java.util.Scanner;

public class Pattern9 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the number");
    int n = scan.nextInt();
    pattern9(n);
    
  }

  public static void pattern9(int n) {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 2 * n - 1; j++) {
        if (i + j == n - 1 || j - i == n - 1) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < 2 * n - 1; j++) {
        if (i == j || j == 2 * n - i - 2) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
