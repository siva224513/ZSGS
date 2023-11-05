package com.siva224513.Array;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
          Scanner scan=new Scanner(System.in);
        System.out.println("Enter Binary Numbers");
         int n=scan.nextInt();
         System.out.println(binaryToDecimal(n));
    }
    static int binaryToDecimal(int n) 
    { 
    
        int dec_value = 0; 
        int base = 1; 
  
        int temp = n; 
        while (temp > 0) { 
            int last_digit = temp % 10; 
            dec_value += last_digit * base; 
            base = base * 2; 
            temp = temp / 10; 
        } 
  
        return dec_value; 
    } 
}
