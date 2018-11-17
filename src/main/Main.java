package main;

import info.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main extends Application {

    public static Stage primaryStage;
    public static Graph graph;

    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;

        Main.graph = null;
        try {
            if (new File("info.bin").exists()) {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream("info.bin"));
                graph = (Graph) os.readObject();
                os.close();
            }

            if (null == graph) {
                System.out.println("File could not be read");
                graph = new Graph();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Main.primaryStage.setTitle("Search-a-Friend");
        Parent pane = FXMLLoader.load(getClass().getResource("/UI/home.fxml"));
        Scene scene = new Scene(pane);
        Main.primaryStage.setScene(scene);
        Main.primaryStage.setMaximized(true);
        Main.primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
