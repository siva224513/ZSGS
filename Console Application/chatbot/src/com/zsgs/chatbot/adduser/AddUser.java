package com.zsgs.chatbot.adduser;

import java.util.Scanner;

import com.zsgs.chatbot.dto.User;

public class AddUser {
    private AddUserViewModel addCanditateViewModel;

    AddUser() {
        addCanditateViewModel = new AddUserViewModel(this);
    }

    

    public void getUserInfo(){
        Scanner scan = new Scanner(System.in);
        User user = new User();
         user.setName(scan.next());
    }
}
