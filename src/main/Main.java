package main;

import info.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Stage primaryStage;
    public static Graph graph;

    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        Main.graph = new Graph();

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
