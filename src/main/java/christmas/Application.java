package christmas;

import christmas.domain.Event;
import christmas.ui.InputView;
import christmas.ui.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printHello();
        int date = Integer.valueOf(inputView.readDate());
        outputView.printNotice();
        List<String> menuOrders = inputView.readMenu();

        Event event = new Event(date, menuOrders);
        outputView.printMenu(event);
        outputView.printTotalAmountBeforeDiscount(event);
        outputView.printGiftMenu(event);
        outputView.printEventHistory(event);
        outputView.printTotalBenefitAmount(event);
        outputView.printTotalAmountAfterDiscount(event);
        outputView.printEventBadge(event);
    }
}
