package UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import main.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Home {

    void personDoesNotExists(String personName) {
        Alert personAlreadyExists = new Alert(Alert.AlertType.ERROR);
        personAlreadyExists.setContentText(personName + " does not exist");
        personAlreadyExists.showAndWait();
    }

    void setNewScene(String fxmlFileName) {
        try {
            Parent newPane = FXMLLoader.load(getClass().getResource(fxmlFileName));
            Main.primaryStage.getScene().setRoot(newPane);
            Main.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updateFile() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("info.bin"));
            os.writeObject(Main.graph);
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void createPerson() {
        setNewScene("createPerson.fxml");
    }

    @FXML private void createFriend() {
        setNewScene("createFriend.fxml");
    }

    @FXML private void viewFriendList() {
        setNewScene("viewFriendList.fxml");
    }

    @FXML private void checkConnection() {
        setNewScene("checkConnection.fxml");
    }

    @FXML private void viewConnection() {
        setNewScene("viewConnection.fxml");
    }

    @FXML private void viewAllPeople() {
        setNewScene("viewAllPeople.fxml");
    }
}
