package com.myprojecticaro.poc_java_joda_time.datetime;

import com.myprojecticaro.poc_java_joda_time.datetime.model.BusinessHours;

import java.time.LocalDateTime;

public class BusinessCalendar {

    private final HolidayProvider holidayProvider;
    private final BusinessHours businessHours;

    public BusinessCalendar(HolidayProvider holidayProvider,
                            BusinessHours businessHours) {
        this.holidayProvider = holidayProvider;
        this.businessHours = businessHours;
    }

    public boolean isBusinessTime(LocalDateTime dateTime) {
        BusinessDate businessDate =
            new BusinessDate(dateTime.toLocalDate(), holidayProvider);

        return businessDate.isBusinessDay() &&
               businessHours.isWithin(dateTime.toLocalTime());
    }
}