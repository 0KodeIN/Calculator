package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculateApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculateApplication.class.getResource("hello-view.fxml"));
        Group root = new Group();
//        InputStream iconStream = getClass().getResourceAsStream("/icon.png");
//        Image image = new Image(iconStream);
        stage.getIcons().add(new Image("C:\\Users\\Nikita\\IdeaProjects\\CalculatorJFX\\src\\main\\java\\icon.png"));
//        String stylesheet = getClass().getResource("C:\\Users\\Nikita\\IdeaProjects\\demo3\\src\\main\\resources\\style.css").toExternalForm();

        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Line line = new Line(0,0,100,100);
        root.getChildren().add(line);
        stage.setTitle("Hello!");
        stage.setScene(scene);
//        scene.getStylesheets().add(stylesheet);
//        stage.getIcons().add(image);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}