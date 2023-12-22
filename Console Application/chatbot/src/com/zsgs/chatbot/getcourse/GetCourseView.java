package com.zsgs.chatbot.getcourse;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zsgs.chatbot.dto.UserDetails;

import java.util.Scanner;

public class GetCourseView {
  private GetCourseViewModel getCourseViewModel;
  Scanner scanner = new Scanner(System.in);
  private static final String CATEGORIES_KEY = "categories";

  public GetCourseView() {
    getCourseViewModel = new GetCourseViewModel(this);
  }

  public void start(UserDetails user) {
    int option;
    do {

      System.out.println("Logged in as: " + user.getName());
      System.out.println("1. Get Course");
      System.out.println("2. Logout");

      option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case 1:
          getCourse();
          break;
        case 2:
          System.out.println("Logged out successfully.");
          user = null;
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
    } while (option != 2);
  }

  public void getCourse() {

    String currentMenu = CATEGORIES_KEY;
    boolean exit = false;
    while (!exit) {
      displayCourse(currentMenu);
      try{
      int choice = scanner.nextInt();
      switch (choice) {
        case 0:
          if (currentMenu.equals("categories")) {
            System.out.println("Already in Main Menu");
          } else {
            currentMenu = CATEGORIES_KEY;
          }
          getCourseViewModel.resetNavigation();
          break;
        case 100:
          getCourseViewModel.navigateBack();
          currentMenu = getCourseViewModel.getCurrentMenu();
          break;

        case -1:
          System.out.println("Exiting...");
          exit = true;
          break;

        default:
          currentMenu = getCourseViewModel.navigateToCourse(String.valueOf(choice), currentMenu);
          getCourseViewModel.addDataToStack(currentMenu);
          break;

      }
    } catch(InputMismatchException e){
       System.out.println("Invaild Input. Please enter a valid number");
       scanner.next();
    }
    }
  }

  public void displayCourse(String categoriesKey) {

    Map<String, Object> selectedCategory = GetCourseViewModel.courses.get(categoriesKey);
    if (getCourseViewModel.list.contains(categoriesKey)) {
      System.out.println("Available Courses:");
      for (Entry<String, Object> entry : selectedCategory.entrySet()) {

        System.out.println(entry.getKey() + ": " + entry.getValue());

      }

    } else {
      getCourseDetails(selectedCategory);
    }
    System.out.println(
        "Enter the course number, '100' to go back, or '0' to go back to categories, or '-1' to exit:");

  }

  private void getCourseDetails(Map<String, Object> selectedCategory) {
    System.out.println("================================================================================");
    System.out.println("                            Course Details             ");
    System.out.println("--------------------------------------------------------------------------------");
    System.out.println("         Title : " + selectedCategory.get("title"));
    System.out.println("   Description : " + selectedCategory.get("description"));
    System.out.println("     Instrctor : " + selectedCategory.get("instructor"));
    System.out.println("        Rating : " + selectedCategory.get("rating"));
    System.out.println("      Duration : " + selectedCategory.get("duration"));
    System.out.println("Enrollment Fee : " + selectedCategory.get("enrollment_fee"));
    System.out.println(" Prerequisites : " + selectedCategory.get("prerequisites"));
    System.out.println("--------------");
    System.out.println("   Review  ");
    System.out.println("--------------");
    printReview(selectedCategory.get("reviews"));
    System.out.println();
    System.out.println("==================================================================================");
    System.out.println();
  }

  private void printReview(Object reviews) {
    if (reviews instanceof List) {
      List<Map<String, Object>> list = (List<Map<String, Object>>) reviews;

      for (Map<String, Object> review : list) {

        System.out.println("User    : " + review.get("user"));
        System.out.println("Comment : " + review.get("comment"));
        System.out.println("Rating  : " + review.get("rating"));
        System.out.println("-----------------------------------");
      }
    }

  }

}
