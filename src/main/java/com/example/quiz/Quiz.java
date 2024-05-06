package com.example.quiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Quiz extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/FXML/quiz2.fxml"));
        stage.setTitle("Quiz");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaxHeight(490);
        stage.setMaxWidth(700);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
