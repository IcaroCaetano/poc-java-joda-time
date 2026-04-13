# poc-java-joda-time

### 1 - API

- LocalDateTime().now()
- LocalDate.of(2030, 1, 1)

Endpoints

```
GET /date/java-time  
GET /date/joda
```

### 2 - Domain-Driven Time Modeling

- java.time.DayOfWeek
- java.time.LocalDate
- java.time.LocalTime
- java.time.LocalDateTime
    - ofInstant
    - 
- java.time.ZoneId
    - systemDefault
- java.time.Instant
    - ofEpochMilli
- java.time.Clock
    - instant()
    - toEpochMilli()
    - DateTimeZone.forID

### 3 - Joda Date Time
- org.joda.time.DateTime
    - getDayOfWeek
    - plusYears
    - plusMonths
    - plusDays
    - plusHours
    - plusMinutes
    - plusSeconds
    - minusDays
    - minusHours
    - minusMinutes
    - minusSeconds
    - withTimeAtStartOfDay
- org.joda.time.DateTimeConstants
- org.joda.time.format.DateTimeFormat
    - forPattern
- org.joda.time.DateTimeZone
    - withZone
    - forID


