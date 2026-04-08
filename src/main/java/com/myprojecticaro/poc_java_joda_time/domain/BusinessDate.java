package com.myprojecticaro.poc_java_joda_time.domain;

import java.time.LocalDate;

public record BusinessDate(LocalDate date) {

    public boolean isWeekend() {

        return date.getDayOfWeek().getValue() >= 6;
    }

    public BusinessDate nextBusinessDay() {
        LocalDate next = date.plusDays(1);

        while (next.getDayOfWeek().getValue() >= 6) {
            next = next.plusDays(1);
        }
        return new BusinessDate(next);
    }
}