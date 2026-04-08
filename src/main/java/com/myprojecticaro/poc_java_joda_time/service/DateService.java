package com.myprojecticaro.poc_java_joda_time.service;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class DateService {

    public String getJavaTime() {

        return LocalDateTime.now().toString();
    }

    public String getJodaTime() {

        return new DateTime().toString();
    }
}