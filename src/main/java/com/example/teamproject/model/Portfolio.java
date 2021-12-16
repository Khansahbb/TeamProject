package com.example.teamproject.model;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Portfolio {

    private ChequingsAccount chequingsAccount;
    private SavingsAccount savingsAccount;
    private CreditAccount creditAccount;


    public Portfolio(ChequingsAccount chequingsAccount, SavingsAccount savingsAccount, CreditAccount creditAccount) {
        this.chequingsAccount = chequingsAccount;
        this.savingsAccount = savingsAccount;
        this.creditAccount = creditAccount;
    }

    public static Portfolio testPortfolio() {

        ChequingsAccount chequingsAccount = new ChequingsAccount();
        SavingsAccount savingsAccount = new SavingsAccount();
        CreditAccount creditAccount = new CreditAccount();

        Account[] accounts = {chequingsAccount, savingsAccount, creditAccount};

        for (int i = 0; i < 3; i++) {
            ArrayList<Transaction> lots = new ArrayList<>();

            for (int j = 0; j < 100; j++) {
                Random random = new Random();
                Transaction transaction = new Transaction();
                transaction.setAmount(random.nextInt(500));
                transaction.setTimestamp(LocalDate.now().minusDays(300).plusDays(random.nextInt(300)));
                lots.add(transaction);
            }
            accounts[i].setTransactions(lots);

        }
        return new Portfolio(chequingsAccount, savingsAccount, creditAccount);

    }


    public ArrayList<Transaction> getSavings() {
        return savingsAccount.getTransactions();
    }

}
