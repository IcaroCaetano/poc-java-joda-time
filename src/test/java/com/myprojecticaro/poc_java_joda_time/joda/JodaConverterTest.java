package com.myprojecticaro.poc_java_joda_time.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JodaConverterTest {

    @Test
    void shouldConvertJodaToJavaTime() {
        DateTime joda = new DateTime(2026, 4, 8, 10, 0,
                DateTimeZone.forID("America/Sao_Paulo"));

        LocalDateTime result = JodaConverter.toJavaTime(joda);

        assertNotNull(result);
    }

    @Test
    void shouldKeepSameInstant_afterConversion() {
        DateTime joda = new DateTime(2026, 4, 8, 10, 0,
                DateTimeZone.forID("America/Sao_Paulo"));

        LocalDateTime javaTime = JodaConverter.toJavaTime(joda);

        long jodaMillis = joda.getMillis();

        long javaMillis = javaTime
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();

        assertEquals(jodaMillis, javaMillis);
    }

    @Test
    void shouldConvertCorrectly_whenUsingUTC() {
        DateTime joda = new DateTime(2026, 4, 8, 13, 0,
                DateTimeZone.UTC);

        LocalDateTime javaTime = JodaConverter.toJavaTime(joda);

        LocalDateTime expected = LocalDateTime.ofInstant(
                joda.toInstant().toDate().toInstant(),
                ZoneId.systemDefault()
        );

        assertEquals(expected, javaTime);
    }

    @Test
    void shouldUseSystemDefaultTimezone() {
        DateTime joda = new DateTime(2026, 4, 8, 10, 0,
                DateTimeZone.UTC);

        LocalDateTime javaTime = JodaConverter.toJavaTime(joda);

        System.out.println(javaTime);

        // Saida: javaTime: 2026-04-08T07:00

        ZoneId systemZone = ZoneId.systemDefault();

        // Saida: systemZone: America/Fortaleza

        System.out.println(systemZone);

        Instant instantJodaTime = joda.toInstant();

        System.out.println(instantJodaTime);

        // Saida: instantJodaTime: 2026-04-08T10:00:00.000Z

        Date dateJavaUtil = instantJodaTime.toDate();

        System.out.println(dateJavaUtil);

        // Saida: dateJavaUtil: Wed Apr 08 07:00:00 BRT 2026

        java.time.Instant javaTimeInstant = dateJavaUtil.toInstant();

        System.out.println(javaTimeInstant);

        // Saida: javaTimeInstant: 2026-04-08T10:00:00Z

        LocalDateTime expected = LocalDateTime.ofInstant(
                javaTimeInstant, systemZone
        );

        assertEquals(expected, javaTime);
    }

    @Test
    void shouldThrowException_whenNullInput() {
        assertThrows(NullPointerException.class, () ->
                JodaConverter.toJavaTime(null)
        );
    }
}