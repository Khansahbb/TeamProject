package com.example.teamproject.controller;


import com.example.teamproject.model.CustomGraphMaker;
import com.example.teamproject.model.Transaction;
import com.example.teamproject.util.CustomTimestamp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class LineChartController {

    private CustomGraphMaker customGraphMaker;

    @FXML
    private BorderPane rootWidget;

    @FXML
    private ChoiceBox monthChoiceBox;

    @FXML
    private ChoiceBox accountChoiceBox;




    @FXML
    void initialize() {
        customGraphMaker = new CustomGraphMaker();

        String[] accounts = {"Savings", "Credit", "Chequings"};
        String[] months = {"All", "Jan", "Feb", "March", "April", "May", "June",
                "July", "Aug", "Sept", "Oct", "Nov", "Dec"};



        accountChoiceBox.setItems(FXCollections.observableArrayList(accounts));
        monthChoiceBox.setItems(FXCollections.observableArrayList(months));

        accountChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                        int index = newValue.intValue();
                        if (index >= 0) {
                            System.out.println("Account selected index: " + index + "Account seleccted::" + accounts[index]);
                            customGraphMaker.setAccountSelected(index);
                            customGraphMaker.refreshYAxis();
                        }

                    }
                }
        );


        monthChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                        int index = newValue.intValue();
                        if (index >= 0) {

                            System.out.println("ALL index::" + index);
                            customGraphMaker.setMonthSelected(index);
                            customGraphMaker.refreshXAxis();
                        }


                    }
                }
        );



        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart lineChart = new LineChart(xAxis, yAxis);

        customGraphMaker.setXAxis(xAxis);
        customGraphMaker.setYAxis(yAxis);
        customGraphMaker.setLineChart(lineChart);


        StackPane pane = new StackPane(lineChart);
        rootWidget.setCenter(pane);



    }



}


