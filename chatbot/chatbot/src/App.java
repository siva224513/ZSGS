import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {
    private static Scanner scan;
    private static Stack<String> navigationHistory;
    private static Map<String, Map<String, String>> courses;
    private static final String CATEGORIES_KEY = "categories";

    public static void main(String[] args) {
        try {
            String path = "D:/ZSGS/chatbot/chatbot/src/courses.json";
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
            scan = new Scanner(System.in);
            courses = (Map<String, Map<String, String>>) jsonObject.get("courses");
            navigationHistory = new Stack<>();
            navigationHistory.push(CATEGORIES_KEY);
            navigateMenu(CATEGORIES_KEY);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void navigateMenu(String currentMenu) {
        // displayCourses(currentMenu);
        boolean exitMenu = false;

        while (!exitMenu) {
            displayCourses(currentMenu);

            int userInput = Integer.parseInt(scan.nextLine());

            switch (userInput) {
                case 0:

                    if (currentMenu.equals(CATEGORIES_KEY)) {
                        System.out.println("Already in categories.");
                    } else {
                        currentMenu = CATEGORIES_KEY;
                    }
                    navigationHistory.clear();

                    break;

                case -1:
                    try {
                        if (!navigationHistory.isEmpty()) {
                            navigationHistory.pop();
                            currentMenu = navigationHistory.peek();
                        }
                    } catch (Exception e) {
                        System.out.println("Exiting...");
                        exitMenu = true;
                    }
                    break;

                default:
                    currentMenu = navigateToCourse(String.valueOf(userInput), currentMenu);
                    navigationHistory.push(currentMenu);
                    break;
            }
        }
    }

    private static void displayCourses(String currentMenu) {

        System.out.println("Available Courses:");
        Map<String, String> selectedCategory = courses.get(currentMenu);
        for (Map.Entry<String, String> entry : selectedCategory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Enter the course number, '-1' to go back, or '0' to go back to categories:");

    }

    private static String navigateToCourse(String userInput, String currentMenu) {
        Map<String, String> selectedCategory = courses.get(currentMenu);
        String selectedMenu = selectedCategory.get(userInput);

        if (selectedCategory.containsKey(userInput)) {
            System.out.println("You selected: " + selectedMenu);
        } else {
            System.out.println("Invalid input. Please try again.");
        }
        return selectedMenu;
    }
}