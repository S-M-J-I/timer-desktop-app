package project.threads;

import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import project.views.ViewFactory;

import java.io.File;

public class CountdownThread extends Thread{

    private long time;

    public CountdownThread(long time) {
        this.time = time;
    }

    private synchronized void stagger() {
        try {
            CountdownThread.sleep(time);
            System.out.println("DONE!");
            showAlert();
            playSound();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private synchronized void showAlert() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ViewFactory viewFactory = new ViewFactory();
                viewFactory.showAlert();
            }
        });
    }


    private synchronized void playSound() {
        String musicFile = "src/project/sounds/alarm.wav";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    @Override
    public void run() {
        stagger();
    }
}
