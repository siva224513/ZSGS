package com.zsgs.chatbot.adduser;

import java.util.Scanner;

import com.zsgs.chatbot.dto.UserDetails;

public class AddUser {
    private AddUserViewModel addUserViewModel;

    public AddUser() {
        addUserViewModel = new AddUserViewModel(this);
    }

    public void getUserInfo() {
        Scanner scanner = new Scanner(System.in);
        UserDetails user = new UserDetails();
        System.out.println("Enter your name:");
        user.setName(scanner.next());
        System.out.println("Enter your email");
        user.setEmail(scanner.next());
        System.out.println("Enter your phoneNumber");
        user.setPhoneNumber(scanner.next());
        addUserViewModel.validate(user);
    }

    public void onSuccess() {
        System.out.println("User added successfully!...");

    }

    public void error(String errorMessage) {
        System.out.println(errorMessage);
    }

}
