package com.siva224513.Patterns.StarPatterns;
import java.util.Scanner;

public class Pattern4 {
     public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=scan.nextInt();
        pattern4(n);
        
    }
   public static void pattern4(int n){
       for(int i=0;i<n;i++){
        for(int j=0;j<2*n-1;j++){
            if(i==n-1||j==n-i-1||j==n+i-1){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
        }
        System.out.println();
       }
    }
}
