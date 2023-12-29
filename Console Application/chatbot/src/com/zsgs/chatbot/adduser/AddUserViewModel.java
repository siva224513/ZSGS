package com.zsgs.chatbot.adduser;

import java.util.Map;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.zsgs.chatbot.dto.UserDetails;
import com.zsgs.chatbot.repository.CourseDataRepository;

public class AddUserViewModel {
    private AddUser addUser;
    Scanner scanner = new Scanner(System.in);

    public AddUserViewModel(AddUser addUser) {
        this.addUser = addUser;
    }

    public void validate(UserDetails user) throws ParseException {
        boolean isValidName = isValidName(user.getName());
        boolean isValidEmail = isValidEmail(user.getEmail());
        boolean isValidPhoneNumber = isValidPhoneNumber(user.getPhoneNumber());

        while (!isValidName || !isValidEmail || !isValidPhoneNumber) {
            System.out.println("Invalid data. Please enter valid information.");
            if (!isValidName) {
                System.out.println("Please enter a valid name:");
                user.setName(new Scanner(System.in).next());
                isValidName = isValidName(user.getName());
            }
            if (!isValidEmail) {
                System.out.println("Please enter a valid email:");
                user.setEmail(new Scanner(System.in).next());
                isValidEmail = isValidEmail(user.getEmail());
            }
            if (!isValidPhoneNumber) {
                System.out.println("Please enter a valid phone number:");
                user.setPhoneNumber(new Scanner(System.in).next());
                isValidPhoneNumber = isValidPhoneNumber(user.getPhoneNumber());
            }
        }
        
        CourseDataRepository.getInstance().addUser(user);
        this.addUser.onSuccess();

    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        String pattern = "^[6-9]\\d{9}$";
        boolean isMatch = phoneNumber.matches(pattern);
        return phoneNumber != null && isMatch;
    }

    public boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        boolean isMatch = email.matches(emailPattern);
        return email != null && isMatch;

    }

    private boolean isValidName(String name) {
        if (name == null || name.length() < 3 || name.length() > 50) {
            return false;
        }
        String namePattern = "^[a-zA-Z ]+$";
        boolean isMatch = name.matches(namePattern);
        return isMatch;
    }

    public UserDetails getUserFromJson(String email) {
        UserDetails user = null;
        Map<String, UserDetails> usersFromJSON = CourseDataRepository.getInstance().getUserDataBase();

        if (usersFromJSON != null) {
            user = usersFromJSON.get(email);
        }
        return user;
    }

}
