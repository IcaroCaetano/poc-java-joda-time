package com.myprojecticaro.poc_java_joda_time.datetime;

import java.time.LocalDate;

public interface HolidayProvider {

    boolean isHoliday(LocalDate date);
}