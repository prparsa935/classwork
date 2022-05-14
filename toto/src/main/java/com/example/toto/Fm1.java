package com.example.toto;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fm1 extends Application {
    @Override
    public void start(Stage primarystage) throws Exception{
        Parent root= FXMLLoader.load(Fm1.class.getResource("Fm1.fxml"));
        primarystage.setTitle("File Manager");
        Scene scene=new Scene(root);
       primarystage.setScene(scene);
       primarystage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

}
