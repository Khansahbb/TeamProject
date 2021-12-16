package com.example.teamproject;

import com.example.teamproject.model.CustomGraphMaker;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TeamProjectMain extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TeamProjectMain.class.getResource(
                "LineChartViewOne.fxml"));
        Tab tabOne = new Tab("View", fxmlLoader.load());

        FXMLLoader fxmlLoader1 = new FXMLLoader(TeamProjectMain.class.getResource(
                "TransactionsViewThree.fxml"));
        Tab tabTwo = new Tab("Edit View", fxmlLoader1.load());

        TabPane tabRoot = new TabPane(tabOne, tabTwo);
        Scene scene = new Scene(tabRoot, 800, 600);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}