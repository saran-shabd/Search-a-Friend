package UI;

import main.*;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.LinkedList;

public class ViewAllPeople {

    @FXML private ListView<String> list;

    @FXML private void initialize() {
        LinkedList<String> peopleList = Main.graph.getAllPeople();
        list.getItems().clear();
        for (String i : peopleList) {
            list.getItems().add(i);
        }
    }

    @FXML private void goHome() {
        new Home().setNewScene("/UI/home.fxml");
    }
}
