package com.template.dashboardui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class AppController implements Initializable {

    @FXML
    private AnchorPane dashboard1Pane;

    @FXML
    private AnchorPane dashboard2Pane;

    @FXML
    private AnchorPane dashboard3Pane;

    @FXML
    private Button dashboardScreen1Button;

    @FXML
    private Button dashboardScreen2Button;

    @FXML
    private Button dashboardScreen3Button;

    @FXML
    void openRespectiveUIs(ActionEvent event) {

        if(event.getSource() == dashboardScreen1Button){

            dashboard1Pane.toFront();

        }else if(event.getSource() == dashboardScreen2Button){

            dashboard2Pane.toFront();

        }else if(event.getSource() == dashboardScreen3Button){

            dashboard3Pane.toFront();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("Dashboard1-view.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("Dashboard2-view.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("Dashboard3-view.fxml"));

        try {
            ScrollPane scrollPane = fxmlLoader1.load();
            AnchorPane.setTopAnchor(scrollPane,0.0);
            AnchorPane.setLeftAnchor(scrollPane,0.0);
            AnchorPane.setRightAnchor(scrollPane,0.0);
            AnchorPane.setBottomAnchor(scrollPane,0.0);
            dashboard1Pane.getChildren().add(scrollPane);

            AnchorPane screen2 = fxmlLoader2.load();
            AnchorPane.setTopAnchor(screen2,0.0);
            AnchorPane.setLeftAnchor(screen2,0.0);
            AnchorPane.setRightAnchor(screen2,0.0);
            AnchorPane.setBottomAnchor(screen2,0.0);
            dashboard2Pane.getChildren().add(screen2);

            AnchorPane screen3 = fxmlLoader3.load();
            AnchorPane.setTopAnchor(screen3,0.0);
            AnchorPane.setLeftAnchor(screen3,0.0);
            AnchorPane.setRightAnchor(screen3,0.0);
            AnchorPane.setBottomAnchor(screen2,0.0);
            dashboard3Pane.getChildren().add(screen3);
        } catch (IOException e) {
            // e.printStackTrace();
        }

        // Changing style on clicked (or hover) functionality to Navigation Buttons
        AtomicReference<String> white1 = new AtomicReference<>();
        AtomicReference<String> white2 = new AtomicReference<>();
        AtomicReference<String> white3 = new AtomicReference<>();

        dashboardScreen1Button.setOnMouseClicked(mouseEvent -> {
            dashboardScreen1Button.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #1e1e1e;");
            dashboardScreen2Button.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
            dashboardScreen3Button.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
            white1.set("-fx-background-color: #FFFFFF;");
        });
        dashboardScreen1Button.setOnMouseEntered(mouseEvent -> {
            if(dashboardScreen1Button.getStyle().contains("-fx-background-color: #FFFFFF;")){
                white1.set("-fx-background-color: #FFFFFF;");
            }else {
                dashboardScreen1Button.setStyle("-fx-background-color: #FCFCFC;");
            }
        });
        dashboardScreen1Button.setOnMouseExited(mouseEvent -> {
            if(white1.get() == null){
                dashboardScreen1Button.setStyle("-fx-background-color: transparent;");
            }else{
                dashboardScreen1Button.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: #1e1e1e");
            }
            white1.set(null);
        });

        dashboardScreen2Button.setOnMouseClicked(mouseEvent -> {
            dashboardScreen1Button.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
            dashboardScreen2Button.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #1e1e1e");
            dashboardScreen3Button.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
            white2.set("-fx-background-color: #FFFFFF;");
        });
        dashboardScreen2Button.setOnMouseEntered(mouseEvent -> {
            if(dashboardScreen2Button.getStyle().contains("-fx-background-color: #FFFFFF;")){
                white2.set("-fx-background-color: #FFFFFF;");
            }else {
                dashboardScreen2Button.setStyle("-fx-background-color: #FCFCFC;");
            }
        });
        dashboardScreen2Button.setOnMouseExited(mouseEvent -> {
            if(white2.get() == null){
                dashboardScreen2Button.setStyle("-fx-background-color: transparent;");
            }else{
                dashboardScreen2Button.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: #1e1e1e");
            }
            white2.set(null);
        });

        dashboardScreen3Button.setOnMouseClicked(mouseEvent -> {
            dashboardScreen1Button.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
            dashboardScreen2Button.setStyle("-fx-background-color: transparent; -fx-text-fill: grey;");
            dashboardScreen3Button.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #1e1e1e");
            white3.set("-fx-background-color: #FFFFFF;");
        });
        dashboardScreen3Button.setOnMouseEntered(mouseEvent -> {
            if(dashboardScreen3Button.getStyle().contains("-fx-background-color: #FFFFFF;")){
                white3.set("-fx-background-color: #FFFFFF;");
            }else {
                dashboardScreen3Button.setStyle("-fx-background-color: #FCFCFC;");
            }
        });
        dashboardScreen3Button.setOnMouseExited(mouseEvent -> {
            if(white3.get() == null){
                dashboardScreen3Button.setStyle("-fx-background-color: transparent;");
            }else{
                dashboardScreen3Button.setStyle("-fx-background-color: #FFFFFF;-fx-text-fill: #1e1e1e");
            }
            white3.set(null);
        });

        dashboard1Pane.toFront();

    }

}
