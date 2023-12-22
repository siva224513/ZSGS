package com.zsgs.quizpro.viewmodel;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.zsgs.quizpro.dto.QuizDetails;
import com.zsgs.quizpro.repository.QuizRepository;
import com.zsgs.quizpro.view.QuizView;

public class QuizViewModel {
    private QuizView quizView;
    int currentQuestionIndex;
    Scanner scan = new Scanner(System.in);
    QuizDetails quizDetails;
    int correctAnswers, totalQuestions;

    public QuizViewModel(QuizView quizView) {
        this.quizView = quizView;

    }

    public boolean moveToNextQuestion(String category) {
        if (currentQuestionIndex < QuizRepository.getInstance().getListSize(category)) {

            quizDetails = QuizRepository.getInstance().getQuestion(category, currentQuestionIndex);
            currentQuestionIndex++;
            return true;
        }
        return false;
    }

    public String[] getOptions() {
        return quizDetails.getOption();
    }

    public int getAnswerIndex() {
        return quizDetails.getAnswerIndex();
    }

    public String getQuestions() {
        return quizDetails.getQuestion();

    }

    public void getFeedback(String userName) {
        System.out.println("\nQuiz ended for " + userName + " !");
        System.out.println("Total questions: " + totalQuestions);
        System.out.println("Correct answers: " + correctAnswers);
        System.out.println("Incorrect answers: " + (totalQuestions - correctAnswers));

        if (correctAnswers == totalQuestions) {
            System.out.println("Congratulations! You answered all questions correctly.");
        } else if (correctAnswers == 0) {
            System.out.println("Better luck next time!");
        } else {
            System.out.println("Well done! Keep improving!");
        }
    }

    public int getUserInput(int maxOption) {
        int answer = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print("Enter your choice (1-" + maxOption + "): ");
                answer = scan.nextInt();

                if (answer >= 1 && answer <= maxOption) {
                    isValidInput = true;
                } else {
                    System.out.println("Please enter a number between 1 and " + maxOption);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");

                scan.nextLine();
            }
        }

        return answer;
    }

    public void getUserAnswer(int answer) {

        if (answer - 1 == getAnswerIndex()) {
            System.out.println("Correct!");
            correctAnswers++;
        } else {
            System.out.println("Incorrect!");
        }
        totalQuestions++;

    }

}
