package com.example.teamproject.controller;

import com.example.teamproject.model.Transaction;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class TransactionsController {


    ArrayList<Transaction> transactions = new ArrayList<Transaction>();


    @FXML
    BorderPane root;

    @FXML
    DatePicker datePicker;

    @FXML
    VBox tableHolder;

    @FXML
    ChoiceBox accountChoiceBox;


    @FXML
    TextField amountTextField;

    TableView table;




    @FXML
    void addTransactionButtonPressed() {
        table.getItems().clear();

        Transaction transaction = new Transaction();
        transaction.setTimestamp(datePicker.getValue());
        transaction.setAmount(Float.valueOf(amountTextField.getText()));
        transaction.setAccount(String.valueOf(accountChoiceBox.getSelectionModel().getSelectedItem()));
        transactions.add(transaction);

        ObservableList<Transaction> transactionObservableList =
                FXCollections.observableArrayList(transactions);


        table.setItems(transactionObservableList);

    }

    public void setTable(TableView table) {
        this.table = table;
    }

    @FXML
    void datePicked(ActionEvent actionEvent) {
        System.out.println("DAte picked..: " + datePicker.getValue());
    }

    @FXML
    void initialize() {

        String[] accounts = {"Savings", "Credit", "Chequings"};
        accountChoiceBox.setItems(FXCollections.observableArrayList(accounts));


        TableView<Transaction> table = new TableView<Transaction>();

        TableColumn<Transaction, String> accountTypeCol = new TableColumn("Account");
        TableColumn<Transaction, Float> amountCol = new TableColumn("Amount");
        TableColumn<Transaction, LocalDate> dateCol = new TableColumn("Date");

        accountTypeCol.setPrefWidth(100);
        amountCol.setPrefWidth(100);

        accountTypeCol.setCellValueFactory(new PropertyValueFactory<Transaction, String>("account"));
        amountCol.setCellValueFactory(new PropertyValueFactory<Transaction, Float>("amount"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Transaction, LocalDate>("date"));


        table.getColumns().addAll(accountTypeCol, amountCol, dateCol);
        tableHolder.getChildren().add(table);
        setTable(table);





    }
}


//        Random random = new Random();
//        Transaction[] transactionList = new Transaction[100];
//        for (int i = 0; i < 50; i++) {
//            Transaction transaction = new Transaction();
//
//            transaction.setAmount(random.nextInt(500));
//            transaction.setTimestamp(LocalDateTime.now().minusDays((random.nextInt(300))));
//            transaction.setAccount(accounts[random.nextInt(2)]);
//
//            transactionList[i] = transaction;
//        }
//
//        ObservableList<Transaction> transactionObservableList =
//                FXCollections.observableArrayList(transactionList);




//        table.setItems(transactionObservableList);