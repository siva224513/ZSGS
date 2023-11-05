package com.siva224513.Patterns.StarPatterns;


import java.util.Scanner;

public class Pattern1{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=scan.nextInt();
        pattern1(n);
        
    }
   public static void pattern1(int n){
       for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
            if(i==0||j==n-1|| i==j){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }
          }
          System.out.println();

       }
    }
}