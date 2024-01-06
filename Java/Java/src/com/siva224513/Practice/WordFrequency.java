

import java.util.HashMap;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        WordFrequency w = new WordFrequency();
        String words = scan.nextLine();
        w.getFrequency(words);

    }

    private void getFrequency(String words) {
        int n = words.length();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String,String> originalWords=new HashMap<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = words.charAt(i);
            if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90)) {
                word.append(c);
            } else if (c == ' '&& word.length() != 0) {
                 String newWord=word.toString().toLowerCase();
                map.put(newWord, map.getOrDefault(newWord, 0) + 1);
                if(!originalWords.containsKey(newWord)){
                    originalWords.put(newWord,word.toString());
                }
                word.setLength(0);


            }
            if (i == n - 1 && word.length() != 0) {
                String newWord=word.toString().toLowerCase();
                map.put(newWord, map.getOrDefault(newWord, 0) + 1);
                 if(!originalWords.containsKey(newWord)){
                    originalWords.put(newWord,word.toString());
                }
            }
            
        }
        
        for (String key : map.keySet()) {
            System.out.println(originalWords.get(key) + "=" + map.get(key) + ", ");
        }

    }

}
