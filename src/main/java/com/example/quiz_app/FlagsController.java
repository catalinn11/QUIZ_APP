package com.example.quiz_app;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class FlagsController implements Initializable {

    @FXML
    private ImageView flagImage;
    @FXML
    private TextField inputChoice;
    @FXML
    private Label displayCount;
    @FXML
    private Button restartButton;
    @FXML
    private Button finishButton;

    EventHandler<KeyEvent> event = new EventHandler<>() {
        @Override
        public void handle(KeyEvent keyEvent) {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (count < FlagsQuiz.flags.length) {
                    if (inputChoice.getText().equalsIgnoreCase(FlagsQuiz.flags[i]))
                        correct++;
                    else
                        wrong++;
                    try {
                        nextFlag();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        handlefinishButton();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    };

    private int i;
    private ArrayList<String> questionsCopy = new ArrayList<>(FlagsQuiz.flags.length);
    //private String[] questionsCopy = new String[FlagsQuiz.flags.length];

    public static int count = 0, correct = 0, wrong = 0;

    private int getRandomValidIndex() {
        Random random = new Random();
        int r;
        while (true) {
            int k = random.nextInt(FlagsQuiz.flags.length);
            if (questionsCopy.contains(FlagsQuiz.flags[k])) {
                questionsCopy.remove(FlagsQuiz.flags[k]);
                r = k;
                break;
            }
        }
        return r;
    }
    private void createCopy() {
        for (int j = 0; j < FlagsQuiz.flags.length; j++) {
            questionsCopy.add(FlagsQuiz.flags[j]);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createCopy();
        count = 0;
        correct = 0;
        wrong = 0;
        inputChoice.setOnKeyPressed(event);
        i = getRandomValidIndex();
        displayCount.setText((count+1) + " / " + FlagsQuiz.flags.length);
        flagImage.setImage(new Image(FlagsQuiz.flags[i] + ".png"));
    }

    public void nextFlag() throws IOException {
        if (questionsCopy.isEmpty())
            handlefinishButton();
        else {
            count++;
            i = getRandomValidIndex();
            flagImage.setImage(new Image(FlagsQuiz.flags[i] + ".png"));
            displayCount.setText((count + 1) + " / " + FlagsQuiz.flags.length);
            inputChoice.setText("");
        }
    }

    public void handlerestartButton() {
        createCopy();
        i = getRandomValidIndex();
        count = 0;
        correct = 0;
        wrong = 0;
        flagImage.setImage(new Image(FlagsQuiz.flags[i] + ".png"));
        displayCount.setText((count+1) + " / " + FlagsQuiz.flags.length);
    }

    public void handlefinishButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("endFlagQuiz.fxml"));
        Stage window = (Stage) finishButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 800, 600));
    }

}
