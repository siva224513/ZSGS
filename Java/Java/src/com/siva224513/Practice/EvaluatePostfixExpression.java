package com.siva224513.Practice;

import java.util.Scanner;
import java.util.Stack;

/**
 * EvaluatePostfixExpression
 */
public class EvaluatePostfixExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number with post expressions +,-,*,/");
        String input = scan.nextLine();
        EvaluatePostfixExpression evaluate = new EvaluatePostfixExpression();
        int result= evaluate.evaluateExpression(input);
        System.out.println(result);

    }

    private int evaluateExpression(String input) {
        int n= input.length();
        Stack<Integer> stack =new Stack<>();
        for(int i=0;i<n;i++){
            char c=input.charAt(i);
            if(c>=48 && c<=57){
                stack.push(c-'0');
            }
            else if(stack.isEmpty() || stack.size()==1&&i==n-1){
               break;
            }
            else{
                int x=stack.pop();
                int y=stack.pop();
                if(c=='+'){
                    stack.push(x+y);    
                }
                else if(c=='-'){
                  stack.push(x-y);
                }
                else if(c=='*'){
                    stack.push(x*y);
                }
                else if(c=='/'){                  
                    stack.push(x/y);                                          
                }
            }
            System.out.println(stack);

        }
        return stack.pop();

        
    }

}