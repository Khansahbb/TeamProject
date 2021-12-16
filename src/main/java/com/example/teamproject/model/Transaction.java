package com.example.teamproject.model;



import com.example.teamproject.util.CustomTimestamp;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class Transaction {

    Float amount;
    String account;
    LocalDate timestamp;
    int dayOfYear;
    private String date;


    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
        dayOfYear = timestamp.getDayOfYear();
        date = timestamp.getMonthValue() + "-" + timestamp.getDayOfMonth() + "-"  + timestamp.getYear();

    }


    public void addInterest() {

    }
}
