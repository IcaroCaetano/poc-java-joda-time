package com.myprojecticaro.poc_java_joda_time.datetime;

import com.myprojecticaro.poc_java_joda_time.datetime.model.BusinessHours;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BusinessCalendarTest {

    @Test
    void shouldReturnTrue_whenBusinessDayAndWithinHours() {
        HolidayProvider holidayProvider = mock(HolidayProvider.class);
        BusinessHours businessHours = mock(BusinessHours.class);

        LocalDateTime dateTime = LocalDateTime.of(2026, 4, 8, 10, 0);

        when(holidayProvider.isHoliday(dateTime.toLocalDate())).thenReturn(false);
        when(businessHours.isWithin(LocalTime.of(10, 0))).thenReturn(true);

        BusinessCalendar calendar = new BusinessCalendar(holidayProvider, businessHours);

        boolean result = calendar.isBusinessTime(dateTime);

        assertTrue(result);
    }

    @Test
    void shouldValidateRealScenario() {
        HolidayProvider holidayProvider = new SimpleHolidayProvider();

        BusinessHours businessHours =
                new BusinessHours(LocalTime.of(9, 0), LocalTime.of(18, 0));

        BusinessCalendar calendar =
                new BusinessCalendar(holidayProvider, businessHours);

        LocalDateTime dateTime = LocalDateTime.of(2026, 4, 8, 10, 0);

        assertTrue(calendar.isBusinessTime(dateTime));
    }
}