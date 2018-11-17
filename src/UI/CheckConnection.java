package UI;

import javafx.scene.control.Alert;
import main.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CheckConnection {

    @FXML private TextField personName;
    @FXML private TextField friendName;

    @FXML private void checkConnection() {
        if (!Main.graph.personExists(personName.getText())) {
            new Home().personDoesNotExists(personName.getText());
            personName.clear();
            return;
        }

        if (!Main.graph.personExists(friendName.getText())) {
            new Home().personDoesNotExists(friendName.getText());
            friendName.clear();
            return;
        }

        if (Main.graph.connectionExists(personName.getText(), friendName.getText())) {
            Alert connectionExists = new Alert(Alert.AlertType.INFORMATION);
            connectionExists.setContentText("Connection exists");
            connectionExists.showAndWait();

            new Home().setNewScene("/UI/home.fxml");
        } else {
            Alert connectionExists = new Alert(Alert.AlertType.INFORMATION);
            connectionExists.setContentText("Connection does not exists");
            connectionExists.showAndWait();

            new Home().setNewScene("/UI/home.fxml");
        }
    }
}
