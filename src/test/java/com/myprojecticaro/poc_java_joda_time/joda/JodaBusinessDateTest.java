package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JodaBusinessDateTest {

    @Test
    void shouldReturnTrue_whenSaturday() {
        JodaBusinessDate date =
                new JodaBusinessDate(new DateTime(2026, 4, 11, 10, 0));

        assertTrue(date.isWeekend());
    }

    @Test
    void shouldReturnTrue_whenSunday() {
        JodaBusinessDate date =
                new JodaBusinessDate(new DateTime(2026, 4, 12, 10, 0));

        assertTrue(date.isWeekend());
    }

    @Test
    void shouldReturnFalse_whenWeekday() {
        JodaBusinessDate date =
                new JodaBusinessDate(new DateTime(2026, 4, 8, 10, 0));

        assertFalse(date.isWeekend());
    }

    @Test
    void shouldReturnTrue_whenBusinessDay() {
        JodaBusinessDate date =
                new JodaBusinessDate(new DateTime(2026, 4, 8, 10, 0));

        assertTrue(date.isBusinessDay());
    }

    @Test
    void shouldReturnFalse_whenWeekend() {
        JodaBusinessDate date =
                new JodaBusinessDate(new DateTime(2026, 4, 11, 10, 0));

        assertFalse(date.isBusinessDay());
    }

    @Test
    void shouldReturnNextDay_whenWeekday() {
        JodaBusinessDate date =
                new JodaBusinessDate(new DateTime(2026, 4, 8, 10, 0));

        JodaBusinessDate next = date.nextBusinessDay();

        assertEquals(new DateTime(2026, 4, 9, 0, 0), next.getDate());
    }

    @Test
    void shouldSkipWeekend_whenFriday() {
        JodaBusinessDate date =
                new JodaBusinessDate(new DateTime(2026, 4, 10, 10, 0));

        JodaBusinessDate next = date.nextBusinessDay();

        assertEquals(new DateTime(2026, 4, 13, 0, 0), next.getDate());
    }

    @Test
    void shouldReturnMonday_whenSaturday() {
        JodaBusinessDate date = new JodaBusinessDate(new DateTime(2026, 4, 11, 10, 0));

        JodaBusinessDate next = date.nextBusinessDay();

        assertEquals(new DateTime(2026, 4, 13, 0, 0), next.getDate());
    }

    @Test
    void shouldReturnMonday_whenSunday() {
        JodaBusinessDate date = new JodaBusinessDate(new DateTime(2026, 4, 12, 10, 0));

        JodaBusinessDate next = date.nextBusinessDay();

        assertEquals(new DateTime(2026, 4, 13, 0, 0), next.getDate());
    }


    @Test
    void shouldNotChangeOriginalDate() {
        JodaBusinessDate date = new JodaBusinessDate(new DateTime(2026, 4, 10, 10, 0));

        JodaBusinessDate next = date.nextBusinessDay();

        assertEquals(new DateTime(2026, 4, 10, 0, 0), date.getDate());
        assertEquals(new DateTime(2026, 4, 13, 0, 0), next.getDate());
    }

    @Test
    void shouldSkipMultipleDaysCorrectly() {
        JodaBusinessDate date = new JodaBusinessDate(new DateTime(2026, 4, 10, 10, 0)); // sexta

        JodaBusinessDate result = date
                .nextBusinessDay()
                .nextBusinessDay();

        assertEquals(new DateTime(2026, 4, 14, 0, 0), result.getDate());
    }
}