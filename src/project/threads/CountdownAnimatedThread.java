package project.threads;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownAnimatedThread extends Thread{

    String time;
    Label label;

    public CountdownAnimatedThread(long time, Label label) {
        this.time = Integer.toString((int)time/1000);
        this.label = label;
    }

    private void update() {
        try {
            CountdownThread.sleep(1000);
            this.label.setText( Integer.toString( Integer.parseInt(this.time) - 1) );
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        int getTime = Integer.parseInt(label.getText()) - 1;
                        int composeTime = getTime >= 0 ? getTime : 0;
                        label.setText( Integer.toString(composeTime) );
                    }
                });
            }
        }, 1000, 1000);
    }
}
