
package com.zsgs.quizpro.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.zsgs.quizpro.dto.QuizDetails;

public class QuizRepository {
    private static QuizRepository quizRepository = null;

    public HashMap<String, List<QuizDetails>> questionsList = new HashMap<>();

    private QuizRepository() {
        initializeQuestions();
    }

    public static QuizRepository getInstance() {
        if (quizRepository == null) {
            quizRepository = new QuizRepository();

        }
        return quizRepository;
    }

    private void initializeQuestions() {
        List<QuizDetails> javaQuestions = new ArrayList<>();
      
        javaQuestions.add(new QuizDetails("Which keyword is used to define a constant in Java?", 
                new String[] { "final", "const", "static", "var" }, 0));
        javaQuestions.add(new QuizDetails("What does JVM stand for?", 
                new String[] { "Java Variable Manager", "Java Visual Machine", "Java Virtual Machine", "Java Viable Method" }, 2));
        javaQuestions.add(new QuizDetails("Which collection class allows you to grow or shrink its size automatically?", 
                new String[] { "ArrayList", "HashMap", "Array", "LinkedList" }, 0));
        javaQuestions.add(new QuizDetails("Which loop is guaranteed to execute at least one time?", 
                new String[] { "while loop", "do-while loop", "for loop", "enhanced for loop" }, 1));
        
        javaQuestions.add(new QuizDetails("What does the 'static' keyword indicate in Java?",
        new String[] {
            "It indicates that the variable or method belongs to the class itself and not to instances of the class.",
            "It indicates that the variable or method can be accessed only within the same package.",
            "It denotes a variable that can be changed anytime during the program execution.",
            "It specifies that the variable or method is constant and cannot be modified."
        }, 0));
        questionsList.put("java", javaQuestions);

        List<QuizDetails> jsQuestions = new ArrayList<>();
        jsQuestions.add(new QuizDetails("What does the DOM stand for in JavaScript?", 
                new String[] { "Document Object Model", "Data Object Model", "Display Object Model", "Design Object Model" }, 0));
        jsQuestions.add(new QuizDetails("Which operator is used to assign a value to a variable?", 
                new String[] { "*", "-", "=", ":" }, 2));
        jsQuestions.add(new QuizDetails("Which method is used to print something in the console?", 
                new String[] { "print()", "log()", "display()", "console()" }, 1));
        jsQuestions.add(new QuizDetails("What is the correct way to write an array in JavaScript?", 
                new String[] { "let colors = [\"red\", \"green\", \"blue\"]", "colors = \"red\", \"green\", \"blue\"", "colors = [\"red\" + \"green\" + \"blue\"]", "colors = {\"red\", \"green\", \"blue\"}" }, 0));
        jsQuestions.add(new QuizDetails("Which statement is used to stop a loop in JavaScript?", 
                new String[] { "continue", "break", "return", "stop" }, 1));
        questionsList.put("js", jsQuestions);

        List<QuizDetails> dsaQuestions = new ArrayList<>();
        dsaQuestions.add(new QuizDetails("What does FIFO stand for?", 
                new String[] { "First In First Out", "First Input First Output", "Fast In Fast Out", "First In First Over" }, 0));
        dsaQuestions.add(new QuizDetails("Which data structure uses the Last In First Out principle?", 
                new String[] { "Queue", "Stack", "Heap", "Linked List" }, 1));
        dsaQuestions.add(new QuizDetails("Which sorting algorithm has the worst-case time complexity of O(n^2)?", 
                new String[] { "Merge Sort", "Quick Sort", "Bubble Sort", "Insertion Sort" }, 2));
        dsaQuestions.add(new QuizDetails("What is the purpose of a hash function in data structures?", 
                new String[] { "To retrieve data", "To generate random numbers", "To compress data", "To encrypt data" }, 0));
        dsaQuestions.add(new QuizDetails("What is the time complexity of searching in a Binary Search Tree?", 
                new String[] { "O(log n)", "O(n)", "O(n^2)", "O(1)" }, 0));
        questionsList.put("dsa", dsaQuestions);
    }


    public QuizDetails getQuestion(String category, int index) {
        List<QuizDetails> questions = questionsList.getOrDefault(category, new ArrayList<>());
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null;
    }

    public int getListSize(String category) {
        return questionsList.getOrDefault(category, new ArrayList<>()).size();
    }

}
