package Programs;

import java.util.Scanner;
import java.util.Stack;

public class Program3 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the mathematical expression");
        String str=scan.next(); 
        int ind=0;
        boolean flag=true;
        for( int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                ind++;
            }
            else if(str.charAt(i)==')'){
                ind--;
            }
            else if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/'){
                if(!((str.charAt(i-1)>=97 &&str.charAt(i-1)<=122)||(str.charAt(i+1)>=97 &&str.charAt(i+1)<=122)||
                (str.charAt(i-1)==')' &&str.charAt(i+1)=='('))){
                    flag=false;
                    break;
                }      
            }

        }
        if(flag&& ind==0){
            System.out.println("valid");
        }
        else{
            System.out.println("Invalid");
        }


       
    }
    
  

    
}
