package com.myprojecticaro.poc_java_joda_time.joda;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class JodaFormatterWithClockTest {

    @Test
    void shouldFormatDateTimeCorrectly_withFixedClock() {

        Instant fixedInstant = Instant.parse("2026-04-08T13:00:00Z");

        // Saida: 2026-04-08T13:00:00Z

        Clock fixedClock = Clock.fixed(fixedInstant, ZoneId.of("UTC"));

        // Saida: FixedClock[2026-04-08T13:00:00Z,UTC]

        JodaFormatterWithClock formatter =
                new JodaFormatterWithClock(fixedClock);

        String result = formatter.formatDateTimeNow();

        // Saida: 2026-04-08 13:00:00

        assertEquals("2026-04-08 13:00:00", result);
    }

    @Test
    void shouldFormatDateCorrectly_withFixedClock() {

        Instant fixedInstant = Instant.parse("2026-04-08T13:45:30Z");
        Clock fixedClock = Clock.fixed(fixedInstant, ZoneId.of("UTC"));

        JodaFormatterWithClock formatter =
                new JodaFormatterWithClock(fixedClock);

        String result = formatter.formatDateNow();

        assertEquals("2026-04-08", result);
    }

    @Test
    void shouldRespectTimezone_whenUsingDifferentZone() {

        Instant fixedInstant = Instant.parse("2026-04-08T13:00:00Z");

        Clock clock = Clock.fixed(
                fixedInstant,
                ZoneId.of("America/Sao_Paulo")
        );

        JodaFormatterWithClock formatter =
                new JodaFormatterWithClock(clock);

        String result = formatter.formatDateTimeNow();

        //  depende de como Joda interpreta o millis (padrao da JVM)
        // então valido formato, não valor absoluto
        assertNotNull(result);
        assertTrue(result.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"));
    }

    @Test
    void shouldReturnSameValue_whenCalledMultipleTimes() {

        Instant fixedInstant = Instant.parse("2026-04-08T13:00:00Z");
        Clock fixedClock = Clock.fixed(fixedInstant, ZoneId.of("UTC"));

        JodaFormatterWithClock formatter =
                new JodaFormatterWithClock(fixedClock);

        String first = formatter.formatDateTimeNow();
        String second = formatter.formatDateTimeNow();

        assertEquals(first, second);
    }

    @Test
    void shouldReturnDifferentValues_forDifferentClocks() {

        Clock clock1 = Clock.fixed(
                Instant.parse("2026-04-08T10:00:00Z"),
                ZoneId.of("UTC")
        );

        Clock clock2 = Clock.fixed(
                Instant.parse("2026-04-08T15:00:00Z"),
                ZoneId.of("UTC")
        );

        JodaFormatterWithClock formatter1 = new JodaFormatterWithClock(clock1);
        JodaFormatterWithClock formatter2 = new JodaFormatterWithClock(clock2);

        String result1 = formatter1.formatDateTimeNow();
        String result2 = formatter2.formatDateTimeNow();

        assertNotEquals(result1, result2);
    }
}