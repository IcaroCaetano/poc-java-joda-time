package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JodaTimezoneTest {

    @Test
    void shouldReturnBrazilTimezone() {
        DateTime dateTime = JodaTimezone.getBrazilTime();

        assertEquals(DateTimeZone.forID("America/Sao_Paulo"), dateTime.getZone());
    }

    @Test
    void shouldConvertToJapanTimezone() {
        DateTime brazilTime = new DateTime(2026, 4, 8, 10, 0,
                DateTimeZone.forID("America/Sao_Paulo"));

        DateTime japanTime = JodaTimezone.convertToJapan(brazilTime);

        assertEquals(DateTimeZone.forID("Asia/Tokyo"), japanTime.getZone());
    }

    @Test
    void shouldKeepSameInstant_whenConvertingTimezone() {
        DateTime brazilTime = new DateTime(2026, 4, 8, 10, 0,
                DateTimeZone.forID("America/Sao_Paulo"));

        DateTime japanTime = JodaTimezone.convertToJapan(brazilTime);

        assertEquals(brazilTime.getMillis(), japanTime.getMillis());
    }

    @Test
    void shouldAdjustHourCorrectly_betweenBrazilAndJapan() {
        DateTime brazilTime = new DateTime(2026, 4, 8, 10, 0,
                DateTimeZone.forID("America/Sao_Paulo"));

        DateTime japanTime = JodaTimezone.convertToJapan(brazilTime);

        assertNotEquals(brazilTime.getHourOfDay(), japanTime.getHourOfDay());
    }

    @Test
    void shouldConvertToCustomTimezone() {
        DateTime utcTime = new DateTime(2026, 4, 8, 12, 0,
                DateTimeZone.UTC);

        DateTime converted = JodaTimezone.convert(utcTime, "Europe/London");

        assertEquals(DateTimeZone.forID("Europe/London"), converted.getZone());
    }

    @Test
    void shouldThrowException_whenInvalidTimezone() {
        DateTime dateTime = new DateTime();

        assertThrows(IllegalArgumentException.class, () ->
                JodaTimezone.convert(dateTime, "Invalid/Timezone")
        );
    }
}