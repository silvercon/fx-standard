package fx.standard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author : silver
 * @since : 2019-05-29 16:24
 */
public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));

        primaryStage.setTitle("FXML Welcome");
        primaryStage.setScene(new Scene(root, 358, 215));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(Launcher.class, args);
    }
}
