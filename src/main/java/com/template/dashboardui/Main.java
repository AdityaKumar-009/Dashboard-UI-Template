package com.template.dashboardui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.template.dashboardui.Dashboard1Controller.executor1;
import static com.template.dashboardui.Dashboard1Controller.executor2;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("App-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setMinHeight(640);
        stage.setMinWidth(1015);
        stage.setScene(scene);
        stage.setTitle("Dashboard Template UI");
        stage.show();

    }

    @Override
    public void stop() {

        // Closing all running services
        executor1.shutdownNow();
        System.out.println("Executor 1 Shutdown: "+executor1.isShutdown());

        executor2.shutdownNow();
        System.out.println("Executor 2 Shutdown: "+executor2.isShutdown());

        System.out.println("Stopped All Services!");

    }
}

