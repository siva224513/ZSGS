
package com.zsgs.quizpro.view;

import java.util.Scanner;

import com.zsgs.quizpro.viewmodel.QuizViewModel;

public class QuizView {
    private QuizViewModel quizViewModel;
    Scanner scan = new Scanner(System.in);
    private String userName;

    public QuizView() {
        quizViewModel = new QuizViewModel(this);
        getUserName();
    }

    public void getUserName() {
        System.out.println("Welcome to the Quiz!");
        System.out.println("Enter your name:");
        userName = scan.nextLine();
    }

    public void chooseCategory() {
        System.out.println("Hello, " + userName + "!");
        System.out.println("Choose a Quiz Category:");
        System.out.println("1.Java Programming\n2.JavaScript\n3.Data Structures");
        String selectedCategory = "";
        int choice = quizViewModel.getUserInput(3);
        switch (choice) {
            case 1:
                selectedCategory = "java";
                break;

            case 2:
                selectedCategory = "js";
                break;
            case 3:
                selectedCategory = "dsa";
                break;
        }
        startQuiz(selectedCategory);

    }

    public void startQuiz(String selectedCategory) {

        while (quizViewModel.moveToNextQuestion(selectedCategory)) {

            String currentQuestion = quizViewModel.getQuestions();
            System.out.println("Question :" + currentQuestion);
            String options[] = quizViewModel.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            int answer = quizViewModel.getUserInput(options.length);

            quizViewModel.getUserAnswer(answer);

        }
        quizViewModel.getFeedback(userName);

    }

    

}
