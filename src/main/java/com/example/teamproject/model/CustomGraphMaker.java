package com.example.teamproject.model;

import com.example.teamproject.util.CustomTimestamp;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;


public class CustomGraphMaker {


    private Portfolio portfolio = Portfolio.testPortfolio();

    private LineChart lineChart;
    private int accountSelected;
    private int monthSelected;
    private int yearSelected;
    private NumberAxis xAxis;
    private NumberAxis yAxis;

    private final String[] months = {"Jan", "Feb", "March", "April", "May", "June",
            "July", "Aug", "Sept", "Oct", "Nov", "Dec"};



    public LineChart getLineChart() {
        return lineChart;
    }

    public void setLineChart(LineChart lineChart) {
        this.lineChart = lineChart;
    }

    public int getAccountSelected() {
        return accountSelected;
    }

    public void setAccountSelected(int accountSelected) {
        this.accountSelected = accountSelected;
    }

    public NumberAxis getXAxis() {
        return xAxis;
    }

    public void setXAxis(NumberAxis xAxis) {
        this.xAxis = xAxis;
    }

    public NumberAxis getYAxis() {
        return yAxis;
    }

    public void setYAxis(NumberAxis yAxis) {
        this.yAxis = yAxis;
    }

    public int getMonthSelected() {
        return monthSelected;
    }

    public void setMonthSelected(int monthSelected) {
        this.monthSelected = monthSelected;
    }

    public int getYearSelected() {
        return yearSelected;
    }

    public void setYearSelected(int yearSelected) {
        this.yearSelected = yearSelected;
    }



    public void setupDateAxis(NumberAxis numberAxis) {


    }

    public void setupMonthlyXAxis(int month) {
        NumberAxis numberAxis = this.getXAxis();
        LocalDate timestamp = LocalDate.of(yearSelected, month, 1);

        numberAxis.setLabel(timestamp.getMonth().toString());
        numberAxis.setAutoRanging(false);
        numberAxis.setLowerBound(1);
        numberAxis.setUpperBound(timestamp.getMonth().length(timestamp.isLeapYear()));
        numberAxis.setTickLength(15);
        numberAxis.setTickUnit(7);


        numberAxis.setTickLabelFormatter(new StringConverter<Number>() {

                                           @Override
                                           public String toString(Number number) {


                                               int num = number.intValue();
                                               boolean checkZero = (num <=0)? true: false;

                                               if (checkZero) {
                                                   return null;
                                               }

                                               LocalDate timestamp = LocalDate.of(yearSelected, month, num);

                                               boolean isTomorrowNewMonth = (timestamp.getMonthValue() !=
                                                       timestamp.plusDays(1).getMonthValue())? true: false;


                                                if  (isTomorrowNewMonth) {
                                                    int monthVal = timestamp.getMonthValue();
                                                    monthVal = (monthVal == 12)? 0: monthVal;
                                                   System.out.println("Month end..:" + number + timestamp.getMonth());
                                                   return months[monthVal];
                                               }
                                                else {

                                                    return String.valueOf(num);
                                                }


                                           }

                                           @Override
                                           public Number fromString(String s) {
                                               return null;
                                           }
                                       }
        );

    }

    public void setupYearlyAxis() {

        NumberAxis numberAxis = xAxis;


        numberAxis.setLabel("Year selected " + yearSelected);
        numberAxis.setAutoRanging(false);

        numberAxis.setTickLength(20);
        numberAxis.setTickUnit(1);

        numberAxis.setLowerBound(1);
        numberAxis.setUpperBound(365);

        numberAxis.setTickLabelFormatter(new StringConverter<Number>() {

                                           @Override
                                           public String toString(Number number) {


                                               int num = number.intValue();
                                               boolean flop = (num <=0)? true: false;

                                               LocalDate timestamp = LocalDate.ofYearDay(2021, num);


                                               if ((timestamp.plusDays(1).getMonthValue() != timestamp.getMonthValue())
                                                       && (!flop)) {


                                                   return months[timestamp.getMonthValue()-1];
                                               }

                                               return null;

                                           }

                                           @Override
                                           public Number fromString(String s) {
                                               return null;
                                           }
                                       }
        );

    }


    public void refreshYAxis() {
        XYChart.Series series = new XYChart.Series();
        series.setName("nammmme");
        ArrayList<Transaction> savings = portfolio.getSavings();

        for (int i = 0; i < savings.size(); i++) {
            Transaction transaction = savings.get(i);
            series.getData().add(new XYChart.Data(transaction.dayOfYear, transaction.amount));
        }

        lineChart.getData().clear();
        lineChart.getData().add(series);


    }





    public void refreshXAxis() {
        if (monthSelected == 0) {
            setupYearlyAxis();
        }
        else {
            setupMonthlyXAxis(monthSelected);
        }

    }

    public XYChart.Series getSavingsSeries() {


        XYChart.Series series = new XYChart.Series();
        series.setName("nammmme");

        series.getData().add(new XYChart.Data("Jan", 0));
        series.getData().add(new XYChart.Data("Feb", 24));
        series.getData().add(new XYChart.Data("Mar", 25));
        series.getData().add(new XYChart.Data("Apr", 34));
        series.getData().add(new XYChart.Data("May", 54));
        series.getData().add(new XYChart.Data("Jun", 16));
        series.getData().add(new XYChart.Data("Jul", 62));
        series.getData().add(new XYChart.Data("Aug", 25));
        series.getData().add(new XYChart.Data("Sep", 63));
        series.getData().add(new XYChart.Data("Oct", 47));
        series.getData().add(new XYChart.Data("Nov", 69));
        series.getData().add(new XYChart.Data("Dec", 15));


        return series;

    }


}
