package fx.standard.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * @author : silver
 * @since : 2019-05-29 21:42
 */
public class ShowAlert {

    public static void alert(AlertType alertType, String title, String message){
        Alert alert = new Alert(alertType);
        alert.titleProperty().set(title);
        alert.headerTextProperty().set(message);
        alert.showAndWait();
    }

}
