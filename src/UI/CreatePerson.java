package UI;

import javafx.scene.control.Alert;
import main.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreatePerson {

    @FXML private TextField personName;

    @FXML private void createPerson() throws IOException {

        if (Main.graph.personExists(personName.getText())) {
            Alert personAlreadyExists = new Alert(Alert.AlertType.ERROR);
            personAlreadyExists.setContentText(personName.getText() + " alerady exists");
            personAlreadyExists.showAndWait();
            personName.clear();
            return;
        }

        Main.graph.addPerson(personName.getText());
        new Home().updateFile();

        Alert personCreate = new Alert(Alert.AlertType.INFORMATION);
        personCreate.setContentText("Person created successfully");
        personCreate.showAndWait();

        new Home().setNewScene("/UI/home.fxml");
    }
}
