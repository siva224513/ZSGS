

import java.util.Scanner;

public class StringPattern {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringPattern m = new StringPattern();
        String word = scan.nextLine();
        m.printPatternString(word);

    }

    private void printPatternString(String word) {

        int n = word.length();
        int length = -1;
        
        for (int i = 2; i < n; i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                length = i;
                break;
            }
        }

        int i = 0, j = length;
        word = word.toUpperCase();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (i < length || j < n) {
            if (i < length)
                sb1.append(word.charAt(i++));
            if (j < n)
                sb2.append(word.charAt(j++));
            System.out.println(sb1.toString() + sb2.toString());
            
        }

    }
}
