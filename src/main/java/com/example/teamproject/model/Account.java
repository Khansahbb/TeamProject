package com.example.teamproject.model;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class Account {

    private float interestRate;

    HashMap<Integer, Transaction[]> transactionsContainer;

    ArrayList<Transaction> transactions;

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void getUpdatedBalance() {};

//    public float getUpdatedBalance(Timestamp timestamp) {
//
//
////        float updatedBalance = 0.0;
//        for (int i = 0; i< transactions.size(); i++) {
//
//            Transaction transaction = new Transaction();
////          float amount = transaction.getAmount();
//        //  int daysPassed = CustomTimeStamp.getDaysPassed(transaction.getTimestamp());
//
//        //  updatedBalance += amount * (interestRate / () );
//
////            return updatedBalance;
//
//
//        }
//
//
//    }

}
