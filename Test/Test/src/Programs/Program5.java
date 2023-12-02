package Programs;

import java.util.Arrays;
import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number of strings to be entered :");
        int n=scan.nextInt();
        String str[]=new String[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the string "+(i+1)+": ");
            str[i]=scan.next();           
        }

        for(int i=0;i<n;i++){
            str[i]=sort(str[i]);
        }
        Arrays.sort(str);
        System.out.println("Lexicographically largest string:\n");
        for(int i=n-1;i>=0;i--){
            System.out.println(str[i]);
        }
    }
   

    
    public static String sort(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int freq1[] = new int[26];
    
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq1[c - 'A']++;
        }
    
        int rev = 25;
        for (int i = 0; i < 26; i++) {
            while (freq1[rev] != 0) {
                sb.append((char) (rev + 'A'));
                freq1[rev]--;  
            }
            
            rev--;
        }
    
        return sb.toString();
    }
    
}
