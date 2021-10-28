package project.threads;

import javafx.scene.control.Label;

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
        update();
    }
}
