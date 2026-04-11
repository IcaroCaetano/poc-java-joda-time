package com.myprojecticaro.poc_java_joda_time.datetime;

import java.time.LocalDate;
import java.util.Set;

public class FixedHolidayProvider implements HolidayProvider {

    private final Set<LocalDate> holidays;

    public FixedHolidayProvider(Set<LocalDate> holidays) {

        this.holidays = holidays;
    }

    @Override
    public boolean isHoliday(LocalDate date) {

        return holidays.contains(date);
    }
}