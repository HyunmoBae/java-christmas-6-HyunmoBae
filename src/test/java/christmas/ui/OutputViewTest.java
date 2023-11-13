package christmas.ui;

import christmas.domain.Event;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }

    @Test
    void printMenuTest() {
        outputView.printMenu(new Event(3, List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1")));
    }

    @Test
    void printTotalAmountAfterDiscountTest() {
        outputView.printTotalAmountAfterDiscount(new Event(3, List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1")));
    }

    @Test
    void printTotalAmountBeforeDiscountTest() {
        outputView.printTotalAmountBeforeDiscount(new Event(3, List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1")));
    }

    @Test
    void printGiftMenuTest() {
        outputView.printGiftMenu(new Event(3, List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1")));
    }

    @Test
    void printEventHistoryTest() {
        outputView.printEventHistory(new Event(3, List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1")));
    }

    @Test
    void printAllDiscountTest() {
        outputView.printAllDiscount(new Event(3, List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1")));
    }

    @Test
    void printTotalDiscountTest() {
        outputView.printTotalDiscount(new Event(3, List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1")));
    }

    @Test
    void printEventBadgeTest() {
        outputView.printEventBadge(new Event(3, List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1")));
    }
}