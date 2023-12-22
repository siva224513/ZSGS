package com.zsgs.chatbot.repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.zsgs.chatbot.dto.UserDetails;

public class CourseDataRepository {
    private static CourseDataRepository repository;
    private static Map<String, Map<String, Object>> courses;

    private CourseDataRepository() {

    }

    public static CourseDataRepository getInstance() {
        if (repository == null) {
            repository = new CourseDataRepository();

        }
        return repository;
    }

    public void initializeMenuFromJSON() {
        try {
            String path = "G:/ZSGS/Console Application/chatbot/src/com/zsgs/chatbot/repository/courses.json";
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
            courses = (Map<String, Map<String, Object>>) jsonObject.get("courses");

        } catch (Exception e) {
            System.err.println("File cannot be loaded");
            System.err.println(e.getMessage());
        }
    }

    public Map<String, Map<String, Object>> getData() {
        return courses;
    }

    public void addUser(UserDetails user) throws org.json.simple.parser.ParseException {
        JSONObject jsonObject;
        String path = "G:/ZSGS/Console Application/chatbot/src/com/zsgs/chatbot/repository/users.json";
        try {
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(new FileReader(path));
            JSONObject users = (JSONObject) jsonObject.get("users");
            if (users.containsKey(user.getEmail())) {
                System.out.println("User already exists with this email.");
            } else {
                // Create a new user object
                JSONObject newUser = new JSONObject();
                newUser.put("name", user.getName());
                newUser.put("email", user.getEmail());
                newUser.put("phoneNumber", user.getPhoneNumber());

                // Add the new user to the "users" object
                users.put(user.getEmail(), newUser);

                // Write the updated JSON back to the file
                FileWriter fileWriter = new FileWriter(path);
                fileWriter.write(jsonObject.toJSONString());
                fileWriter.flush();
                fileWriter.close();

                System.out.println("User added successfully to JSON file!");
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public Map<String, UserDetails> getUserDataBase() {
        Map<String, UserDetails> userDataBase = new HashMap<String, UserDetails>();
        try {
            String path = "G:/ZSGS/Console Application/chatbot/src/com/zsgs/chatbot/repository/users.json";
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(path));
            userDataBase = (Map<String, UserDetails>) jsonObject.get("users");
            for (Object key : userDataBase.keySet()) {
                String userEmail = (String) key;
                Map<String, String> userDetailsObject = (Map<String, String>) userDataBase.get(userEmail);
                String name = (String) userDetailsObject.get("name");
                String phoneNumber = (String) userDetailsObject.get("phoneNumber");

                // Create UserDetails object
                UserDetails user = new UserDetails();
                user.setName(name);
                user.setEmail(userEmail);
                user.setPhoneNumber(phoneNumber);

                userDataBase.put(userEmail, user);

            }

        } catch (Exception e) {
            System.err.println("File cannot be loaded");
            System.err.println(e.getMessage());
        }

        return userDataBase;
    }
}
