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
        event = new Event("abc", 18, List.of("시저샐러드-3", "티본스테이크-1", "아이스크림-2", "샴페인-1"));
        int result = event.getTotalAmountBeforeDiscount();
        assertThat(result).isEqualTo(114000);
    }

    @Test
    void getTotalAmountBeforeDiscountTest3() {
        event = new Event("abc", 17, List.of("초코케이크-2", "바비큐립-1", "레드와인-1"));
        int result = event.getTotalAmountBeforeDiscount();
        assertThat(result).isEqualTo(144000);
    }

    @Test
    void dayOfDiscountTest1() {
        event = new Event("abc", 15, List.of("타파스-1", "바비큐립-2", "해산물파스타-1", "제로콜라-1", "아이스크림-1"));
        int result = event.getTotalAmountAfterDiscount(156500);
        assertThat(result).isEqualTo(148031);
    }

    @Test
    void dayOfDiscountTest2() {
        event = new Event("abc", 18, List.of("시저샐러드-3", "티본스테이크-1", "아이스크림-2", "샴페인-1"));
        int result = event.getTotalAmountAfterDiscount(114000);
        assertThat(result).isEqualTo(107254);
    }

    @Test
    void dayOfDiscountTest3() {
        event = new Event("abc", 17, List.of("초코케이크-2", "바비큐립-1", "레드와인-1"));
        int result = event.getTotalAmountAfterDiscount(144000);
        assertThat(result).isEqualTo(136354);
    }

    @Test
    void giftEventTest1() {
        event = new Event("abc", 15, List.of("타파스-1", "바비큐립-2", "해산물파스타-1", "제로콜라-1", "아이스크림-1"));
        String result = event.isGiftEvent(120000);
        assertThat(result).isEqualTo("샴페인 1개");
    }

    @Test
    void giftEventTest2() {
        event = new Event("abc", 15, List.of("타파스-1", "바비큐립-2", "해산물파스타-1", "제로콜라-1", "아이스크림-1"));
        String result = event.isGiftEvent(10000);
        assertThat(result).isEqualTo("없음");
    }

    @Test
    void getEventBadgeTest1() {
        event = new Event("abc", 17, List.of("초코케이크-2", "바비큐립-1", "레드와인-1"));
        String result = event.getBadge();
        assertThat(result).isEqualTo("별");
    }

    @Test
    void getEventBadgeTest2() {
        event = new Event("abc", 17, List.of("초코케이크-5", "바비큐립-1", "레드와인-1"));
        String result = event.getBadge();
        assertThat(result).isEqualTo("트리");
    }

    @Test
    void getEventBadgeTest3() {
        event = new Event("abc", 17, List.of("초코케이크-10", "바비큐립-1", "레드와인-1"));
        String result = event.getBadge();
        assertThat(result).isEqualTo("산타");
    }

    @Test
    void getEventBadgeTest4() {
        event = new Event("abc", 17, List.of("바비큐립-1", "레드와인-1"));
        String result = event.getBadge();
        assertThat(result).isEqualTo("없음");
    }
}