package Programs;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number :");
        int n=scan.nextInt();
        if(isValid(n)){
            System.out.println(n+" is a jumbled number");
        }
        else{
             System.out.println(n+" is not a jumbled number");
        }
           
    }
    public static boolean isValid(int n){
        int prev=n%10;
        n/=10;
        int curr=0;
        while (n!=0) {
            curr=n%10;
            if((curr+1)!=prev && (curr-1)!=prev){
                if(curr!=prev)
                {
                 return false;
                }
            }
            n/=10;
            prev=curr;
        }
        return true;
    }
}
