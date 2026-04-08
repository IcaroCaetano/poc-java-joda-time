package com.myprojecticaro.poc_java_joda_time.domain.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public record BusinessDate(LocalDate date) {

    public boolean isWeekend() {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }


    public boolean isBusinessDay() {
        return !isWeekend();
    }


    public BusinessDate nextBusinessDay() {
        LocalDate next = date.plusDays(1);

        while (isWeekend(next)) {
            next = next.plusDays(1);
        }

        return new BusinessDate(next);
    }

    private boolean isWeekend(LocalDate d) {
        return d.getDayOfWeek() == DayOfWeek.SATURDAY ||
                d.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}