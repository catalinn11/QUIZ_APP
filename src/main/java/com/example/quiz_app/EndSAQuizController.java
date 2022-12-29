package com.example.quiz_app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndSAQuizController extends SAQuizController implements Initializable {

    @FXML
    Button homeButton;
    @FXML
    private Label endQuizText;

    @FXML
    private Label correctQuiz;
    @FXML
    private Label wrongQuiz;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        endQuizText.setText("CONGRATULATIONS, YOU HAVE COMPLETED \n" + count + " QUESTIONS!");
        correctQuiz.setText(Integer.toString(correct));
        wrongQuiz.setText(Integer.toString(wrong));
    }

    public void onHomeButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("capitalsQuiz.fxml"));
        Stage window = (Stage) homeButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),800, 600));
    }
}
