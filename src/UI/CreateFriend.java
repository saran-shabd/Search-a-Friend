package UI;

import javafx.scene.control.Alert;
import main.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateFriend {

    @FXML private TextField personName;
    @FXML private TextField friendName;

    @FXML private void createFriends() {

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

        Main.graph.addFriend(personName.getText(), friendName.getText());

        Alert friendsCreated = new Alert(Alert.AlertType.INFORMATION);
        friendsCreated.setContentText("Friends created successfully");
        friendsCreated.showAndWait();

        new Home().setNewScene("/UI/home.fxml");
    }
}
