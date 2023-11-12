package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class EventTest {

    private Event event;

    @Test
    void getTotalAmountBeforeDiscountTest() {
        event = new Event("abc", 15, List.of("타파스-1", "바비큐립-2", "해산물파스타-1", "제로콜라-1", "아이스크림-1"));
        int result = event.getTotalAmountBeforeDiscount();
        assertThat(result).isEqualTo(156500);
    }

    @Test
    void getTotalAmountBeforeDiscountTest2() {
        event = new Event("abc", 15, List.of("시저샐러드-3", "티본스테이크-1", "아이스크림-2", "샴페인-1"));
        int result = event.getTotalAmountBeforeDiscount();
        assertThat(result).isEqualTo(114000);
    }

    @Test
    void getTotalAmountBeforeDiscountTest3() {
        event = new Event("abc", 15, List.of("초코케이크-2", "바비큐립-1", "레드와인-1"));
        int result = event.getTotalAmountBeforeDiscount();
        assertThat(result).isEqualTo(144000);
    }
}