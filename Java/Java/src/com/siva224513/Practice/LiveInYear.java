

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class LiveInYear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LiveInYear l = new LiveInYear();
        System.out.println("Enter the year want to check");
        int year = scan.nextInt();
        l.checkYear(year);
    }

    private void checkYear(int year) {
        HashMap<String, List<Integer>> peopleDetails = new HashMap<>();
        peopleDetails.put("Siva", Arrays.asList(2000, 2050));
        peopleDetails.put("Ramesh", Arrays.asList(1850, 1920));
        peopleDetails.put("Prabha", Arrays.asList(2002, 2090));
        peopleDetails.put("Surya", Arrays.asList(1945, 2010));
        peopleDetails.put("Vijay", Arrays.asList(1983, 2000));

        System.out.println("People lives in the " + year + ":");
        int k = 0;
        boolean isFound = false;
        for (Map.Entry<String, List<Integer>> entry : peopleDetails.entrySet()) {
            String name = entry.getKey();
            List<Integer> years = entry.getValue();
            int birthYear = years.get(0);
            int deathYear = years.get(1);
            if (birthYear <= year && deathYear >= year) {
                System.out.println(++k + ": " + name);
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("No people found living in the given year.");
        }
    }

}
