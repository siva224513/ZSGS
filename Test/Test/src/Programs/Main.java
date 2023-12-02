package Programs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number");
        int number=scan.nextInt();
        // String answer=(number%3==0&&number%5==0)?"multiple of 3 and 5": 
        // (number%3==0)?"multiple of 3":
        // (number%5==0)?"multiple of 5":
        // "Not multiple of 3 and 5";
       // System.out.println(answer);
       int sum=0;
       for(int i=3;i<=number;i++ ){
            if(i%3==0&&i%5==0){
                sum+=i;
            }
            else if(i%3==0){
                sum+=i;
            }
            else if(i%5==0){
                sum+=i;
            }
            
       }
       System.out.println(sum);
    }
}
