package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JodaDateOperationsTest {

    @Test
    void shouldAddDaysCorrectly() {
        DateTime before = new DateTime();

        DateTime result = JodaDateOperations.addDays(before,5);

        DateTime expected = before.plusDays(5);

        assertTrue(isClose(expected, result));
    }

    @Test
    void shouldAddHoursCorrectly() {
        DateTime before = new DateTime();

        DateTime result = JodaDateOperations.addHours(3);

        DateTime expected = before.plusHours(3);

        assertTrue(isClose(expected, result));
    }


    @Test
    void shouldMinusDaysCorrectly() {
        DateTime before = new DateTime();

        DateTime result = JodaDateOperations.minusDays(2);

        DateTime expected = before.minusDays(2);

        assertTrue(isClose(expected, result));
    }

    @Test
    void shouldAddMinutesCorrectly() {
        DateTime before = new DateTime();

        DateTime result = JodaDateOperations.addMinutes(10);

        DateTime expected = before.plusMinutes(10);

        assertTrue(isClose(expected, result));
    }

    @Test
    void shouldMinusSecondsCorrectly() {
        DateTime before = new DateTime();

        DateTime result = JodaDateOperations.minusSeconds(30);

        DateTime expected = before.minusSeconds(30);

        assertTrue(isClose(expected, result));
    }

    @Test
    void shouldAddDateTimeCorrectly() {
        DateTime before = new DateTime();

        DateTime result = JodaDateOperations.addDateTime(
                1, 2, 3,
                4, 5, 6
        );

        DateTime expected = before
                .plusYears(1)
                .plusMonths(2)
                .plusDays(3)
                .plusHours(4)
                .plusMinutes(5)
                .plusSeconds(6);

        assertTrue(isClose(expected, result));
    }

    private boolean isClose(DateTime expected, DateTime actual) {
        long diff = Math.abs(expected.getMillis() - actual.getMillis());

        return diff < 50;
    }
}