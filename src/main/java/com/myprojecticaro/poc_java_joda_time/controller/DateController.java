package com.myprojecticaro.poc_java_joda_time.controller;

import com.myprojecticaro.poc_java_joda_time.service.DateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/date")
public class DateController {

    private final DateService service;

    public DateController(DateService service) {
        this.service = service;
    }

    @GetMapping("/java-time")
    public String javaTime() {
        return service.getJavaTime();

        // Output: 2026-04-07T22:33:46.649
    }

    @GetMapping("/joda")
    public String jodaTime() {
        return service.getJodaTime();

        // Output: 2026-04-07T22:43:23.770-03:00
    }
}