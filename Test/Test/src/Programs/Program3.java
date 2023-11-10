package Programs;

import java.util.Scanner;
import java.util.Stack;

public class Program3 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the mathematical expression");
        String str=scan.next(); 
        int ind=0,i=0;
        for( i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                ind++;
            }
            else if(str.charAt(i)==')'){
                ind--;
            }
            else if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/'){
                if((str.charAt(i-1)>=97 &&str.charAt(i-1)<=122)||(str.charAt(i+1)>=97 &&str.charAt(i+1)<=122)){
                    continue;
                }
                else{
                    break;
                }
            }

        }
        if(i==str.length()&& ind==0){
            System.out.println("valid");
        }
        else{
            System.out.println("Invalid");
        }


        // Stack<Character> s=new Stack<>();
        //  boolean result=isValid(str);
        //  if(result)System.out.println("Valid");
        //  else System.out.println("Invalid");
        
    }
    
   /*  public static boolean isValid(String str,Stack<Character> s){
         for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='('){
                s.push(')');
            }
            else if(c=='a'){
                s.push('b');
            }
           
            else if((c=='+'||c=='-'||c=='*'||c=='/')&&s.size()>=2){
               continue;
            }
             else if(s.peek()=='b'&&(c!='+'&&c!='-'&&c!='*'&&c!='/')){
                return false;
            }
            else if(s.isEmpty() ||s.pop()!=c){
                return false;
            }
        }
        return s.isEmpty();
    }   

        */

    
}
