package Programs;

import java.util.Scanner;


public class Program3 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the mathematical expression");
        String str=scan.next(); 
        int ind=0;
        boolean flag=true;
        int n=str.length();
        for( int i=0;i<n;i++){
            if(str.charAt(i)=='('){
                ind++;
            }
            else if(str.charAt(i)==')'){
                if(i==0){
                    flag=false;
                    break;
                }
                ind--;
            }
            else if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/'){
                if((i>0&&(str.charAt(i-1)>=97 &&str.charAt(i-1)<=122)||str.charAt(i-1)==')'||str.charAt(i-1)=='(')
                &&(i<n-1&&(str.charAt(i+1)>=97 &&str.charAt(i+1)<=122)||str.charAt(i+1)==')'||str.charAt(i+1)=='('))
                {
                    flag=true;       
                                 
                }      
                else{
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
