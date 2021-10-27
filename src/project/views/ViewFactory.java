package project.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.controller.BaseController;
import project.controller.TimerController;

import java.io.IOException;

public class ViewFactory {
    public void showWindow() {
        BaseController controller = new TimerController(this, "TimerWindow");

        init_window(controller, "Timer");
    }

    private void init_window(BaseController controller, String title) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        loader.setController(controller);

        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);

        stage.show();
    }
}
