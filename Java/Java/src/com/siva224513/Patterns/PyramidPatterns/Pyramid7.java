package com.siva224513.Patterns.PyramidPatterns;

import java.util.Scanner;

public class Pyramid7 {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the number");
      int n = scan.nextInt();
      pyramid7(n);
      
   }

   public static void pyramid7(int n) {
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= n - i; j++) {
            System.out.print(" ");
         }
         for (int j = 1; j <= i; j++) {
            System.out.print(j + " ");
         }
         System.out.println();
      }
   }
}
