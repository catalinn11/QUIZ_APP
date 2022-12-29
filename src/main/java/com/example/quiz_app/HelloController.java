package com.example.quiz_app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private Button capitalsGame;
    @FXML
    private Button flagsGame;

    public void capitalsGameHandle() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("capitalsQuiz.fxml"));
        Stage window = (Stage) capitalsGame.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),800, 600));
    }

    public void flagsGameHandle() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("flagsQuiz.fxml"));
        Stage window = (Stage) flagsGame.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),800, 600));
    }
}