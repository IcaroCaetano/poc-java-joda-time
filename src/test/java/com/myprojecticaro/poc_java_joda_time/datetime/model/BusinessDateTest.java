package com.myprojecticaro.poc_java_joda_time.datetime.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BusinessDateTest {

    @Test
    void shouldReturnTrue_whenSaturday() {
        BusinessDate date = new BusinessDate(LocalDate.of(2026, 4, 11));

        assertTrue(date.isWeekend());

        //Saida - Sabasdo
    }

    @Test
    void shouldReturnTrue_whenSunday() {
        BusinessDate date = new BusinessDate(LocalDate.of(2026, 4, 12));

        assertTrue(date.isWeekend());

        //Saida - domingo
    }

    @Test
    void shouldReturnFalse_whenWeekday() {
        BusinessDate date = new BusinessDate(LocalDate.of(2026, 4, 8));

        assertFalse(date.isWeekend());

        //Saida - quarta
    }
}