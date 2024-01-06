
import java.util.ArrayList;
import java.util.Scanner;

public class CombinationString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CombinationString c = new CombinationString();
        System.out.println("Enter the String");
        String input = scan.next();
        c.checkCombination(input);

    }

    private void checkCombination(String input) {
        ArrayList<String> list = new ArrayList<>();
        getCombination("", input, list);
        System.out.println(list);
    }

    private void getCombination(String curr, String input, ArrayList<String> list) {
        if (input.length() == 0) {
            if (curr.length() != 0)
                list.add(curr);
            return;
        }
        getCombination(curr + input.charAt(0), input.substring(1), list);
        getCombination(curr, input.substring(1), list);
    }
}
