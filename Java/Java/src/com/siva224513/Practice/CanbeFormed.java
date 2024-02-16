import java.util.Scanner;

public class CanbeFormed {
    public static void main(String[] args) {
        CanbeFormed obj = new CanbeFormed();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter string1:");
        String s1 = scan.nextLine();
        System.out.println("Enter string2:");
        String s2 = scan.nextLine();
        boolean result = obj.checkString(s1, s2);
        if (result) {
            System.out.println(s2 + " can be formed");
        } else {
            System.out.println(s2 + " cannot be formed");
        }

    }

    private boolean checkString(String s1, String s2) {
        String str1 = toLowerCase(s1);
        String str2 = toLowerCase(s2);

        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            freq1[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            freq2[str2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq2[i] != 0) {
                if (freq1[i] != freq2[i]) {
                    return false;
                }
            }
        }
        return true;

    }

    private String toLowerCase(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                char ch = (char) (c + 32);
                result += ch;
            } else {
                result += c;
            }
        }
        return result;
    }

}
