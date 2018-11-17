package UI;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import main.Main;

import java.util.ArrayList;
import java.util.LinkedList;

public class ViewConnection {

    @FXML private TextField personName;
    @FXML private TextField friendName;

    @FXML private ListView<String> list;

    @FXML private void showConnection() {
        if (!Main.graph.personExists(personName.getText())) {
            new Home().personDoesNotExists(personName.getText());
            personName.clear();
            return;
        }

        if (!Main.graph.personExists(friendName.getText())) {
            new Home().personDoesNotExists(friendName.getText());
            personName.clear();
            return;
        }

        LinkedList<ArrayList<String>> connections = Main.graph.showConnection(personName.getText(), friendName.getText());
        if (null == connections) {
            Alert noConnections = new Alert(Alert.AlertType.INFORMATION);
            noConnections.setContentText("No connections exist");
            noConnections.show();
            return;
        }

        list.getItems().clear();

        for (ArrayList<String> counter : connections) {
            StringBuilder temp = new StringBuilder();
            for (String i : counter) {
                temp.append(i);
                temp.append(" <-> ");
            }
            list.getItems().add(temp.toString());
        }
    }

    @FXML private void goHome() {
        new Home().setNewScene("/UI/home.fxml");
    }
}
