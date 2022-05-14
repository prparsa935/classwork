package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.*;
import java.net.URL;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class Fm1Controller implements Initializable {


    @FXML
    private Button del;

    @FXML
    private Button edit;

    @FXML
    private Label fm;

    @FXML
    private Pane pane;

    @FXML
    private TextField search;
    @FXML
    private FlowPane FlowPane;
    @FXML
    private FlowPane List;
    @FXML
    private ScrollPane ScBar;
    @FXML
    private Button Folder;



    private String[] ll={"ss","aas"};

    public void show_drives() throws IOException {
        for (Path root : FileSystems.getDefault().getRootDirectories()) {
            FileStore fileStore = Files.getFileStore(root);
            System.out.format("%s\t%s\n", root, fileStore.getAttribute("volume:isRemovable"));
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            InputStream stream = new FileInputStream("F:\\university\\term2\\minofam\\classwork\\demo\\src\\icons8-folder-96.png");
            Image image = new Image(stream);
            for(int i=0;i<100;i++){
                ImageView ImageView=new ImageView();
                ImageView.setImage(image);
                Button B=new Button();
                B.setText("lllll");
                B.setGraphic(ImageView);
                List.getChildren().add(B);
                B.setStyle("-fx-background-color: #f4f4f4; ");
                B.setContentDisplay(ContentDisplay.TOP);
                B.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("hello");
                    }
                });
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }
}