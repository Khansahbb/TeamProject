package com.example.teamproject.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class CustomTimestamp {


    public static LocalDate getCurrentTimestamp() {
        System.out.println("Time now::" + LocalDate.now());
        System.out.println("Day month..." + LocalDate.now().getMonthValue());
        return LocalDate.now();

    }


    public static int calculateDaysPassed(LocalDate startingDate) {
        LocalDate currentTime = getCurrentTimestamp();

        return currentTime.compareTo(startingDate);

    }




}
