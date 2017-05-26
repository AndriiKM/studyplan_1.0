import javafx.scene.control.Alert;

/**
 * Created by Андрій on 26.05.2017.
 */
public class AlertInfo {
    private String message;

    AlertInfo(String message){
        this.message = message;
    }

    Alert getInfoAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText(MyDataBase.message);
        alert.showAndWait();

        return alert;
    }
    Alert getError() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Предупреждение");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

        return alert;
    }
}


