package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.services.AppointmentService;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        UserService.initDatabase();
        AppointmentService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("firstview.fxml"));
        primaryStage.setTitle("Login or Sign-Up!");
        primaryStage.setScene(new Scene(root, 1000 , 700));
        primaryStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }


    public static void main(String[] args) {
        launch(args);

    }


}