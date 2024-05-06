package com.example.quiz;

public class Context {

    static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }
        return instance;
    }

    private static Context instance = null;

    private Context() {
    }

    public QuizController getQuizController() {
        return quizController;
    }

    public void setQuizController(QuizController quizController) {
        this.quizController = quizController;
    }

    QuizController quizController;

}
