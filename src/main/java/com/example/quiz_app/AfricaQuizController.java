package com.example.quiz_app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfricaQuizController implements Initializable {

    @FXML
    private Button buttonFinish;
    @FXML
    private Button Choice1;
    @FXML
    private Button Choice2;
    @FXML
    private Button Choice3;
    @FXML
    private Button Choice4;
    @FXML
    private Label questionText;
    @FXML
    private Label displayCount;
    private int i;
    public static int count = 0, correct = 0, wrong = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        i = 0;
        count = 0;
        correct = 0;
        wrong = 0;
        questionText.setText(AfricaQuiz.questions[0]);
        Choice1.setText(AfricaQuiz.choices[0][0]);
        Choice2.setText(AfricaQuiz.choices[0][1]);
        Choice3.setText(AfricaQuiz.choices[0][2]);
        Choice4.setText(AfricaQuiz.choices[0][3]);
        displayCount.setText(i+1 + " / " + AfricaQuiz.questions.length);
    }

    public void onRestartButton() {
        i = 0;
        count = 0;
        correct = 0;
        wrong = 0;
        questionText.setText(AfricaQuiz.questions[0]);
        Choice1.setText(AfricaQuiz.choices[0][0]);
        Choice2.setText(AfricaQuiz.choices[0][1]);
        Choice3.setText(AfricaQuiz.choices[0][2]);
        Choice4.setText(AfricaQuiz.choices[0][3]);
        displayCount.setText(i+1 + " / " + AfricaQuiz.questions.length);
    }

    public void nextQuestion() {
        i++;
        count++;
        questionText.setText(AfricaQuiz.questions[i]);
        Choice1.setText(AfricaQuiz.choices[i][0]);
        Choice2.setText(AfricaQuiz.choices[i][1]);
        Choice3.setText(AfricaQuiz.choices[i][2]);
        Choice4.setText(AfricaQuiz.choices[i][3]);
        displayCount.setText(i+1 + " / " + AfricaQuiz.questions.length);
    }

    public void countScore1() throws IOException {
        if (count < AfricaQuiz.questions.length) {
            try {
                if (Choice1.getText().equals(AfricaQuiz.correctAnswers[i])) {
                    correct++;
                } else {
                    wrong++;
                }
                nextQuestion();
            } catch (ArrayIndexOutOfBoundsException e) {
                onFinishButton();
            }
        }
    }

    public void countScore2() throws IOException {
        if (count < AfricaQuiz.questions.length) {
            try {
                if (Choice2.getText().equals(AfricaQuiz.correctAnswers[i])) {
                    correct++;
                } else {
                    wrong++;
                }
                nextQuestion();
            } catch (ArrayIndexOutOfBoundsException e) {
                onFinishButton();
            }
        }
    }

    public void countScore3() throws IOException {
        if (count < AfricaQuiz.questions.length) {
            try {
                if (Choice3.getText().equals(AfricaQuiz.correctAnswers[i])) {
                    correct++;
                } else {
                    wrong++;
                }
                nextQuestion();
            } catch (ArrayIndexOutOfBoundsException e) {
                onFinishButton();
            }
        }
    }

    public void countScore4() throws IOException {
        if (count < AfricaQuiz.questions.length) {
            try {
                if (Choice4.getText().equals(AfricaQuiz.correctAnswers[i])) {
                    correct++;
                } else {
                    wrong++;
                }
                nextQuestion();
            } catch (ArrayIndexOutOfBoundsException e) {
                onFinishButton();
            }
        }
    }

    public void onFinishButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("endAfricaquiz.fxml"));
        Stage window = (Stage) buttonFinish.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 800, 600));
    }
}
