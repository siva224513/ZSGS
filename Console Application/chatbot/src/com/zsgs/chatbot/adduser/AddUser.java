package com.zsgs.chatbot.adduser;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.zsgs.chatbot.dto.UserDetails;

public class AddUser {
    private AddUserViewModel addUserViewModel;
    public UserDetails user = new UserDetails();
    Scanner scanner = new Scanner(System.in);

    public AddUser() {
        addUserViewModel = new AddUserViewModel(this);
    }

    public void displayWelcomeMessage() throws ParseException {
        System.out.println(
                "**************************************************************************************************************");
        System.out.println(
                "*                              Welcome to Our Online Course Platform!                                        *");
        System.out.println(
                "*                 Expand your knowledge and skills with our diverse range of courses                         *");
        System.out.println(
                "*                                  Let's get started!                                                        *");
        System.out.println(
                "**************************************************************************************************************");

        System.out.println();

        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("1.SignUp");
                System.out.println("2.SignIn");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        signUp();
                        exit = true;
                        break;

                    case 2:
                        signIn();
                        exit = true;
                        break;

                    default:
                        System.out.println("invaild choice. Please enter 1 or 2");
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

    }

    public void signUp() throws ParseException {

        System.out.println("Please enter your details to access our courses");
        System.out.println("Enter your name:");
        user.setName(scanner.next());
        System.out.println("Enter your email");
        user.setEmail(scanner.next());
        System.out.println("Enter your phoneNumber");
        user.setPhoneNumber(scanner.next());
        addUserViewModel.validate(user);
    }

    public void signIn() {
        String email = "";
        boolean validEmail = false;
        while (!validEmail) {
            System.out.println("Enter your email:");
            email = scanner.nextLine();
            if (addUserViewModel.isValidEmail(email)) {
                validEmail = true;
            } else {
                System.out.println("Invalid email format...Please insert a valid email");
            }
        }

        user = addUserViewModel.getUserFromJson(email);
        boolean isValidPhoneNumber = false;

        if (user != null) {
            while (!isValidPhoneNumber) {
                System.out.println("Enter your number");
                String phoneNumber = scanner.next();
                if (addUserViewModel.isValidPhoneNumber(phoneNumber)) {
                    if (phoneNumber.equals(user.getPhoneNumber())) {
                        System.out.println("Sign-in Successful! Welcome, " + user.getName());
                        isValidPhoneNumber = true;
                    } else {
                        System.out.println("Incorrect phone number. Please try again.");
                    }
                } else {
                    System.out.println("Invalid phone number format. Please enter a valid phone number.");
                }
            }
        } else {
            System.out.println("User Not Found. Please SignUp to create an account");
        }

    }

    public void onSuccess() {
        System.out.println("User added successfully!...");

    }

   
    public void error(String errorMessage) {
        System.out.println(errorMessage);
    }

}
