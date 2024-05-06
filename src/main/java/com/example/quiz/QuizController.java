package com.example.quiz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuizController implements Initializable {

    private int result = 0;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;

    @FXML
    private Circle c4;

    @FXML
    private Circle c5;

    @FXML
    private Circle c6;

    @FXML
    private Circle c7;

    @FXML
    private Circle c8;

    @FXML
    private Circle c9;

    @FXML
    private Circle c10;

    @FXML
    private Circle c11;

    @FXML
    private Circle c12;

    @FXML
    private Button btnOpenResult;

    @FXML
    private Label welcomeText;

    @FXML
    private RadioButton rBtn1;

    @FXML
    private RadioButton rBtn2;

    @FXML
    private RadioButton rBtn3;

    @FXML
    private RadioButton rBtn4;

    @FXML
    private Text headline;

    @FXML
    private TextField Question;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    static RadioButton[] rightAnswer;
    static RadioButton[] radioButton;
    Circle[] circles;

    public void openResultWindow() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/FXML/result.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Quiz");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaxHeight(430);
        stage.setMaxWidth(600);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    String[] questions = new String[]{"Q1| What is the syntax to declare a variable in Java?",
            "Q2| What data type is used to store a single character in Java?",
            "Q3| Which access modifier restricts access to the members within the same package?",
            "Q4| What keyword is used to define a constant value in Java?",
            "Q5| Which loop is guaranteed to execute at least once in Java?",
            "Q6| What is the superclass of all classes in Java?",
            "Q7| What keyword is used to define a method that does not return any value?",
            "Q8| Which operator is used to concatenate strings in Java?",
            "Q9| What is the output of the expression (5 + 2 * 3)?",
            "Q10| Which of the following is not a valid Java identifier?",
            "Q11| What keyword is used to create a new instance of a class in Java?",
            "Q12| Which method is used to obtain the length of an array in Java?"};

    String[][] variants = {{"int x = 10;", "variable x = 10;", "x = 10;", "double x = 10;"},
            {"char", "string", "byte", "boolean"},
            {"private", "protected", "package-private", "public"},
            {"final", "static", "const", "constant"},
            {"for loop", "while loop", "do-while loop", "if-else statement"},
            {"Object", "Main", "Parent", "Super"},
            {"void", "null", "return", "method"},
            {"+", "&", "||", "$"},
            {"11", "21", "17", "23"},
            {"_variable", "$variable", "variable_123", "123_variable"},
            {"new", "create", "alloc", "instanceof"},
            {"length()", "getSize()", "size()", "length"}};
    Question question = new Question("Questions", questions, variants);

    int k = 0;

    public void buildQuestion() {
        headline.setText("Questions");
        Question.setText(questions[k]);
        for (int i = 0; i < 4; i++) {
            radioButton[i].setText(variants[k][i]);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        radioButton = new RadioButton[]{rBtn1, rBtn2, rBtn3, rBtn4};
        rightAnswer = new RadioButton[]{rBtn2, rBtn4, rBtn3, rBtn4, rBtn1, rBtn4, rBtn1, rBtn1, rBtn3, rBtn1, rBtn2, rBtn2};
        circles = new Circle[]{c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
        rBtn1.setText("");
        System.out.println("QuizController was created!");
        Context.getInstance().setQuizController(this);

        buildQuestion();
    }

    public void inf(String path) {
        int[] rightAnswers = {0, 0, 2, 0, 2, 0, 0, 0, 2, 3, 0, 0};
        try (FileWriter writer = new FileWriter(path, true)) {
            int j = k + 1;
            writer.write(j + " вопрос: ");
            for (int i = 0; i < 4; i++) {
                if (radioButton[i].isSelected()) {
                    writer.write(" ваш ответ - " + ++i);

                }
            }
            writer.write(", правильный ответ - " + rightAnswers[k]);

            if (rightAnswer[k].isSelected()) {
                System.out.println("верно");
                writer.write(", верно");
                writer.append('\n');
                ++result;
                System.out.println(result);
            } else {
                System.out.println(" неверно");
                writer.write(", неверно");
                writer.append('\n');
            }

            if (k == rightAnswer.length - 1) {
                writer.write("Всего правильных " + result + " из " + rightAnswer.length);
            }


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void btnAnswer(MouseEvent mouseEvent) {
        /*FileChooser fileChooser = new FileChooser();
        File f = fileChooser.showOpenDialog(Question.getScene().getWindow());
        System.out.println(f)*/
        ;
        inf("quiz.txt");


        if (k == rightAnswer.length) {
            openResultWindow();

        } else {
            circles[k].setStyle("-fx-stroke-width: 8.0");
            if (rightAnswer[k].isSelected()) {
                circles[k].setStyle("-fx-fill: green; -fx-stroke:transparent");
                //++result;
                //System.out.println(result);
            } else {
                circles[k].setStyle("-fx-fill: red; -fx-stroke:transparent");
                System.out.println("неверно");
            }
            ++k;
            if (k < rightAnswer.length) {
                buildQuestion();
            } else {
                openResultWindow();
            }

        }

    }


    public void rBtn1Clicked(MouseEvent mouseEvent) {
    }

    public void rBtn2Clicked(MouseEvent mouseEvent) {
    }

    public void rBtn3Clicked(MouseEvent mouseEvent) {
    }

    public void rBtn4Clicked(MouseEvent mouseEvent) {
    }


}

