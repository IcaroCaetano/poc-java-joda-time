package com.myprojecticaro.poc_java_joda_time.domain;

import java.time.LocalDate;

public class BusinessDate {

    private final LocalDate date;
    private final HolidayProvider holidayProvider;

    public BusinessDate(LocalDate date, HolidayProvider holidayProvider) {
        this.date = date;
        this.holidayProvider = holidayProvider;
    }

    public boolean isBusinessDay() {
        return !isWeekend(date) && !holidayProvider.isHoliday(date);
    }

    public BusinessDate nextBusinessDay() {
        LocalDate next = date.plusDays(1);

        while (!isBusinessDay(next)) {
            next = next.plusDays(1);
        }

        return new BusinessDate(next, holidayProvider);
    }

    private boolean isBusinessDay(LocalDate d) {

        return !isWeekend(d) && !holidayProvider.isHoliday(d);
    }

    private boolean isWeekend(LocalDate d) {

        return d.getDayOfWeek().getValue() >= 6;
    }
}