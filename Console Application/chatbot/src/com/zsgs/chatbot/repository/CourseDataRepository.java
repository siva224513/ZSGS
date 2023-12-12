package com.zsgs.chatbot.repository;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.zsgs.chatbot.dto.UserDetails;

public class CourseDataRepository {
    private static CourseDataRepository repository;
    private static Map<String, Map<String, Object>> courses;
    private static Map<String, UserDetails> userDataBase = new HashMap<String, UserDetails>();

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
            String path = "D:/ZSGS/Console Application/chatbot/src/com/zsgs/chatbot/repository/courses.json";
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

    public void addUser(UserDetails user) {

        userDataBase.put(user.getEmail(), user);

    }

    public Map<String, UserDetails> getUserDataBase() {
        return userDataBase;
    }
}
