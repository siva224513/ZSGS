package Programs;

import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the string");
        String s=scan.next();
        System.out.println("Enter number of rows");
        int n=scan.nextInt();
        int length=s.length();
        int ind=0,i=0,j=0;
        char ch[][]=new char[n][length];
        boolean up=false;
        while (ind<length) {
            ch[i][j]=s.charAt(ind++);
            if(i==0){
                up=false;
            }
            else if(i==n-1){
                up=true;
            }
            if(up){
                i--;
                j++;
            }
            else{
                i++;
                
            }
        }
        for (char[] row : ch) {
            for (char element : row) {
                
                    System.out.print(element +"  ");
                
            }
            System.out.println("");
        }
        
        
        

    }
}
