package com.siva224513.Practice;

import java.util.Scanner;

public class UniquePermutation {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        String input =scan.next();
        UniquePermutation u =new UniquePermutation();
        u.uniquePermutation(input," ");
    }
    void uniquePermutation(String input , String result){
      
       
        if (input.length() == 0) {
			System.out.print(result + " ");
			return;
		}

		for (int i = 0; i < input.length(); i++) {	
			char ch = input.charAt(i);	
			String temp= input.substring(0, i) +
						input.substring(i + 1);	
			uniquePermutation(temp, result + ch);

        
    }
  }
}
