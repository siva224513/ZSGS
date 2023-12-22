package com.zsgs.quizpro.dto;

public class QuizDetails {
    private String question;
    private String[] options;
    private int correctAnswerIndex;

    public QuizDetails(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public QuizDetails() {
        
    }

    public String getQuestion() {
     
        return question;
    }

    public String[] getOption() {
        
       return options;
    }

    public int getAnswerIndex() {
       
        return correctAnswerIndex;
    }

}
