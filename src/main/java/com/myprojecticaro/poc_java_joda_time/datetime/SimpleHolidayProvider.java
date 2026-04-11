package com.myprojecticaro.poc_java_joda_time.datetime;

import java.time.LocalDate;

class SimpleHolidayProvider implements HolidayProvider {

    @Override
    public boolean isHoliday(LocalDate date) {

        return false;
    }
}