package com.siva224513.Patterns.PyramidPatterns;

import java.util.Scanner;

public class Pyramid4 {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the number");
      int n = scan.nextInt();
      pyramid4(n);
      
   }

   public static void pyramid4(int n) {

      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= n; j++) {
            if (j <= n - i) {
               System.out.print(" ");
            } else {
               System.out.print(j);
            }
         }
         for (int j = 1; j < i; j++) {
            System.out.print(n - j);
         }

         System.out.println();
      }
   }
}
