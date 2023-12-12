
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Question3 obj = new Question3();
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        obj.getFrequency(input);


    }

    private void getFrequency(String input) {
        String word = "";
        HashMap<String,Integer> map=new HashMap<String,Integer>();


        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                word += c;

            } else if (c == ' ' && word.length() != 0) {
                map.put(word,map.getOrDefault(word, 0)+1);
                word = "";

            } 
             if (i == input.length() - 1 && word.length()!=0) {
                map.put(word,map.getOrDefault(word, 0)+1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(a,b)->b.getValue().compareTo(a.getValue()));
        System.out.println(list);
       
    }
}
