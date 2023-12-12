
package com.zsgs.chatbot.getcourse;

import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.zsgs.chatbot.repository.CourseDataRepository;

public class GetCourseViewModel {
    private GetCourseView getCourseView;
    public static Map<String, Map<String, Object>> courses;
    public  List<String> list = Arrays.asList("categories", "Design", "Development", "Marketing",
            "It and Software", "Personal Development", "Business", "Photography");
    private static Stack<String> navigationStack = new Stack<>();

    public GetCourseViewModel(GetCourseView getCourseView) {
        this.getCourseView = getCourseView;
        retrieveData();
    }

    public void retrieveData() {
        CourseDataRepository.getInstance().initializeMenuFromJSON();
        courses = CourseDataRepository.getInstance().getData();
    }

    public String navigateToCourse(String userInput, String currentMenu) {
        Map<String, Object> selectedCategory = courses.get(currentMenu);
        Object selectedMenu = selectedCategory.get(userInput);

        if (selectedCategory.containsKey(userInput)) {
            System.out.println("You selected: " + selectedMenu);
        } else {
            System.out.println("Invalid input. Please try again.");
        }
        return (String) selectedMenu;
    }

    public void addDataToStack(String currentMenu) {
        navigationStack.push(currentMenu);
    }

    public void resetNavigation() {
        navigationStack.clear();
    }

    public void navigateBack() {
        if (!navigationStack.isEmpty()) {
            navigationStack.pop();
        }
    }

    public String getCurrentMenu() {
        if (!navigationStack.isEmpty()) {
            return navigationStack.peek();
        }
        return "categories";
    }

}
