package telran.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import org.junit.jupiter.api.Test;

public class DateTimeTest {
    @Test
    void localDateTest() {
        LocalDate current = LocalDate.now();
        LocalDateTime currentTime = LocalDateTime.now();
        ZonedDateTime currentZonedTime = ZonedDateTime.now();
        Instant currentInstant = Instant.now();
        LocalTime currentLocalTime = LocalTime.now();
        System.out.printf("Current date is %s in ISO format \n", current);
        System.out.printf("Current date & time is %s in ISO format \n", currentTime);
        System.out.printf("Current zoned date & time is %s in ISO format \n", currentZonedTime);
        System.out.printf("Current instant is %s in ISO format \n", currentInstant);
        System.out.printf("Current time is %s in ISO format \n", currentLocalTime);
        System.out.printf("Current date is %s in dd/mm/yyyy \n",
                current.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.forLanguageTag("he"))));

    }

    @Test
    void nextFriday13Test() {
        LocalDate current = LocalDate.of(2024, 8, 11);
        LocalDate expected = LocalDate.of(2024, 9, 13);
        TemporalAdjuster adjuster = new NextFriday13();
        assertEquals(expected, current.with(adjuster));
        assertThrowsExactly(java.time.temporal.UnsupportedTemporalTypeException.class,
                () -> LocalTime.now().with(adjuster));
    }

}