package com.zsgs.chatbot;

import java.util.Scanner;



import com.zsgs.chatbot.adduser.AddUser;
import com.zsgs.chatbot.dto.UserDetails;
import com.zsgs.chatbot.getcourse.GetCourseView;

public class ChatBot {

  public static void main(String[] args)  {
    ChatBot chatbot = new ChatBot();
    chatbot.init();
  }

  private void init()  {

    AddUser addUser = new AddUser();
    UserDetails user = null;
    boolean exit = false;
    // boolean isLoggedOut=false;

    while (!exit) {

      addUser.displayWelcomeMessage();
      user = addUser.user;
      if (user != null) {
        GetCourseView getCourse = new GetCourseView();
        getCourse.start(user);
       
      }else{
        System.out.println("User not found. Please try again");
      }
      
      System.out.println("Do you want to exit? (y/n)");
      Scanner scanner = new Scanner(System.in);
      String choice = scanner.next();

      if (choice.equalsIgnoreCase("y")) {
        exit = true;
        System.out.println("Goodbye!");
      }
    }

  }

}
