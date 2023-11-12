package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CalendarTest {

    private Calendar calendar;

    @BeforeEach
    void setUp() {
        calendar = new Calendar();
    }

    @Test
    void weekdayTest() {
        List<String> result = calendar.isDay(4);
        assertThat(result).isEqualTo(List.of("weekday"));
    }

    @Test
    void weekendTest() {
        List<String> result = calendar.isDay(15);
        assertThat(result).isEqualTo(List.of("weekend"));
    }

    @Test
    void specialDayAndWeekdayTest() {
        List<String> result = calendar.isDay(25);
        assertThat(result).isEqualTo(List.of("weekday", "specialDay"));
    }

}