package com.siva224513.Array;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=scan.nextInt();
        decimalToBinary(n);
    }
    static void decimalToBinary(int n){
        int[] binaryNum = new int[32]; 
        
        int i = 0; 
        while (n > 0) { 
            
            binaryNum[i] = n % 2; 
            n = n / 2; 
            i++; 
        } 
  
        for (int j = i - 1; j >= 0; j--) 
            System.out.print(binaryNum[j]);
    }
}
