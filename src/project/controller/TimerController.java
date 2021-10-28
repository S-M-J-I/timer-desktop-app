package project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import project.threads.CountdownAnimatedThread;
import project.threads.CountdownThread;
import project.views.ViewFactory;

import java.io.File;
import java.io.IOException;

public class TimerController extends BaseController{
    public TimerController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private Label hourOne;

    @FXML
    private Label hourTwo;

    @FXML
    private Label minOne;

    @FXML
    private Label minTwo;

    @FXML
    private Label secOne;

    @FXML
    private Label secTwo;

    @FXML
    void onStartTimer(ActionEvent event) {
        String hourString = hourOne.getText() + hourTwo.getText();
        String minString = minOne.getText() + minTwo.getText();
        String secString = secOne.getText() + secTwo.getText();

        // TODO: compose the time
        long composedHour = Integer.parseInt(hourString) * 3600L;
        long composedMin = Integer.parseInt(minString) * 60L;
        long composedSec = Integer.parseInt(secString);
        long composedTime = (composedHour + composedMin + composedSec) * 1000L;

        System.out.println(composedTime);
        Thread countdown = new CountdownThread(composedTime);

        countdown.setDaemon(true);
        countdown.start();
    }


    @FXML
    void onhourOneDownBtn(ActionEvent event) {
        int curr = Integer.parseInt(hourOne.getText());
        int next = (curr > 0 ? curr - 1 : 0);
        hourOne.setText(Integer.toString(next));
    }

    @FXML
    void onhourOneUpBtn(ActionEvent event) {
        int curr = Integer.parseInt(hourOne.getText());
        int next = curr + 1;
        hourOne.setText(Integer.toString(next));
    }

    @FXML
    void onhourTwoDownBtn(ActionEvent event) {
        int curr = Integer.parseInt(hourTwo.getText());
        int next = (curr > 0 ? curr - 1 : 0);
        hourTwo.setText(Integer.toString(next));
    }

    @FXML
    void onhourTwoUpBtn(ActionEvent event) {
        int curr = Integer.parseInt(hourTwo.getText());
        int next = curr + 1;
        hourTwo.setText(Integer.toString(next));
    }

    @FXML
    void onminOneDownBtn(ActionEvent event) {
        int curr = Integer.parseInt(minOne.getText());
        int next = (curr > 0 ? curr - 1 : 0);
        minOne.setText(Integer.toString(next));
    }

    @FXML
    void onminOneUpBtn(ActionEvent event) {
        int curr = Integer.parseInt(minOne.getText());
        int next = curr + 1;
        minOne.setText(Integer.toString(next));
    }

    @FXML
    void onminTwoDownBtn(ActionEvent event) {
        int curr = Integer.parseInt(minTwo.getText());
        int next = (curr > 0 ? curr - 1 : 0);
        minTwo.setText(Integer.toString(next));
    }

    @FXML
    void onminTwoUpBtn(ActionEvent event) {
        int curr = Integer.parseInt(minTwo.getText());
        int next = curr + 1;
        minTwo.setText(Integer.toString(next));
    }

    @FXML
    void onsecOneDownBtn(ActionEvent event) {
        int curr = Integer.parseInt(secOne.getText());
        int next = (curr > 0 ? curr - 1 : 0);
        secOne.setText(Integer.toString(next));
    }

    @FXML
    void onsecOneUpBtn(ActionEvent event) {
        int curr = Integer.parseInt(secOne.getText());
        int next = curr + 1;
        secOne.setText(Integer.toString(next));
    }

    @FXML
    void onsecTwoDownBtn(ActionEvent event) {
        int curr = Integer.parseInt(secTwo.getText());
        int next = (curr > 0 ? curr - 1 : 0);
        secTwo.setText(Integer.toString(next));
    }

    @FXML
    void onsecTwoUpBtn(ActionEvent event) {
        int curr = Integer.parseInt(secTwo.getText());
        int next = curr + 1;
        secTwo.setText(Integer.toString(next));
    }
}
