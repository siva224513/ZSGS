import java.util.Scanner;

public class LongestPalindromicSubString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        LongestPalindromicSubString longestPalindromicSubString = new LongestPalindromicSubString();
        longestPalindromicSubString.findLongestPalindromicSubString(input, input.length());
    }

    private void findLongestPalindromicSubString(String s, int n) {
        int maxLength = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String temp = s.substring(j, n);
                if (isPalindrome(temp)) {

                    maxLength = Math.max(maxLength, temp.length());
                }
            }
        }
        System.out.println(maxLength);

    }

    private boolean isPalindrome(String s) {

        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }

}