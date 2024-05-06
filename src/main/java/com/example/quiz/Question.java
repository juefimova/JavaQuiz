package com.example.quiz;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

public class Question {
    String headline;
    public String[][] variants;
    public String[] questions;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }


    public Question(String headline, String[] questions, String[][]variants) {
        this.headline = headline;
        this.questions = questions;
        this.variants = variants;

    }

}
