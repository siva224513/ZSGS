package com.zsgs.chatbot;

import com.zsgs.chatbot.adduser.AddUser;
import com.zsgs.chatbot.getcourse.GetCourseView;

public class ChatBot {

  public static void main(String[] args) {
    ChatBot chatbot = new ChatBot();
    chatbot.init();
  }

  private void init() {
   GetCourseView getcourse=new GetCourseView();
   getcourse.getCourse();
  //  AddUser addUser=new AddUser();
  //  addUser.getUserInfo();


  }

}
