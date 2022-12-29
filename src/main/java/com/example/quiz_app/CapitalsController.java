package com.example.quiz_app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CapitalsController {

    @FXML
    private Button euButton;
    @FXML
    private Button asiaButton;
    @FXML
    private Button northaButton;
    @FXML
    private Button southaButton;
    @FXML
    private Button changeGame;

    public void changeGameHandle() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage window = (Stage) changeGame.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),800, 600));
    }
    public void euButtonHandle() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("euquiz.fxml"));
        Stage window = (Stage) euButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),800, 600));
    }
    public void asiaButtonHandle() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("asiaquiz.fxml"));
        Stage window = (Stage) asiaButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),800, 600));
    }
    public void northaButtonHandle() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("naquiz.fxml"));
        Stage window = (Stage) euButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),800, 600));
    }
    public void southaButtonHandle() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("saquiz.fxml"));
        Stage window = (Stage) euButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),800, 600));
    }
    public void africaButtonHandle() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("africaquiz.fxml"));
        Stage window = (Stage) euButton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),800, 600));
    }


}