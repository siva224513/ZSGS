package com.siva224513.Patterns.StarPatterns;
import java.util.Scanner;

public class Pattern5 {
     public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=scan.nextInt();
        pattern5(n);
        
    }
   public  static void pattern5(int n){
       for(int i=0;i<n;i++){
        for(int j=0;j<2*n-1;j++){
           if((i==0&&j<n)||(i==n-1&& j>=n-1)||j==i||j==n+i-1){
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
