import java.util.Scanner;

public class PrintPattern {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the String:");
        String s=scan.nextLine();
        int length=s.length();
         print(s,length);
        scan.close();
    }
    public static void print(String s,int n){
        if(n%2==0){
            System.out.println("0");
        }
        else{
            for(int i=0;i<n;i++){
                int k=n-i-1;
                for(int j=0;j<n;j++){
                    if(j==i||j==k){
                        System.out.print(s.charAt(j));
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                System.out.println(" ");
            }
        }
    }
}
