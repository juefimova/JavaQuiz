package com.example.quiz;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultController implements Initializable {
    @FXML
    private Label lbResult;

    @FXML
    private Button btnClose;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        QuizController quizController = Context.getInstance().getQuizController();
        lbResult.setText("Your result is " + Integer.toString(quizController.getResult()));
    }

    public void closeResultWindow(MouseEvent mouseEvent) {
        lbResult.getScene().getWindow().hide();
    }
}
