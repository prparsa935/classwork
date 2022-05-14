package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welscomeText;

    @FXML
    protected void onHelloButtonClick() {
        welscomeText.setText("Welcome to JavaFX Application!");
    }
}