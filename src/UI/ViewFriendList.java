package UI;

import main.*;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class ViewFriendList {

    @FXML private TextField personName;
    @FXML private ListView<String> list;

    @FXML private void viewFriendList() {
        if (!Main.graph.personExists(personName.getText())) {
            new Home().personDoesNotExists(personName.getText());
            personName.clear();
            return;
        }

        LinkedList<String> friendList = Main.graph.getFriendList(personName.getText());

        list.getItems().clear();
        for (String i : friendList) {
            list.getItems().add(i);
        }
    }

    @FXML private void goHome() {
        new Home().setNewScene("/UI/home.fxml");
    }
}
