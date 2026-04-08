package com.myprojecticaro.poc_java_joda_time.domain.model;

import java.time.LocalTime;

public record BusinessHours(LocalTime start, LocalTime end) {

    public boolean isWithin(LocalTime time) {

        return !time.isBefore(start) && !time.isAfter(end);
    }
}