package christmas.ui;

import camp.nextstep.edu.missionutils.Console;
import christmas.common.Menu;
import christmas.error.ErrorMessage;
import christmas.error.ErrorMessage.ErrorMessageType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public String readName() {
        String name = "";

        System.out.println("예약자명을 입력해주세요!");
        while (true) {
            try {
                name = Console.readLine();
                break;
            } catch (IllegalArgumentException e) {
                ErrorMessage.printErrorMessage(ErrorMessageType.INVALID_NAME);
            }
        }
        return name;
    }

    public int readDate() {
        int date = 0;

        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        while (true) {
            try {
                date = Integer.parseInt(Console.readLine());
                validateDate(date);
                break;
            } catch (IllegalArgumentException e) {
                ErrorMessage.printErrorMessage(ErrorMessageType.INVALID_DATE_VALUE);
            }
        }
        return date;
    }

    public List<String> readMenu() {
        List<String> menuOrders = new ArrayList<>();
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        while (true) {
            try {
                String inputMenuOrders = Console.readLine();
                menuOrders = List.of(inputMenuOrders.split(","));
                validateMenu(menuOrders);
                break;
            } catch (IllegalArgumentException e) {
                ErrorMessage.printErrorMessage(ErrorMessageType.INVALID_MENU_VALUE);
            }
        }
        return menuOrders;
    }

    public void validateDate(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_DATE_VALUE.getMessage());
        }
    }

    public void validateMenu(List<String> menuOrders) {
        validateMenuDuplicate(filterMenuOrders(menuOrders));
        validateMenuValue(filterMenuOrders(menuOrders));
        validateMenuCount(menuOrders);
    }

    public void validateMenuCount(List<String> menuOrders) {
        int totalMenuCount = 0;

        for (String menu : menuOrders) {
            int menuCount = Integer.parseInt(menu.substring(7));
            if (menuCount >= 1 || menuCount <= 20) {
                totalMenuCount += menuCount;
            } else if (menuCount < 1 || menuCount > 20) {
                throw new IllegalArgumentException(ErrorMessageType.INVALID_MENU_VALUE.getMessage());
            }
        }
        if (totalMenuCount > 20) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_MENU_VALUE.getMessage());
        }
    }

    public List<String> filterMenuOrders(List<String> menuOrders) {
        List<String> menuNames = new ArrayList<>();
        for (String menu : menuOrders) {
            menuNames.add(menu.substring(0, menu.indexOf("-")));
        }
        return menuNames;
    }

    public void validateMenuDuplicate(List<String> menuNames) {
        Set<String> nonDuplicateMenuNames = new HashSet<>();
        for (String menu : menuNames) {
            if (!nonDuplicateMenuNames.add(menu.substring(0, menu.indexOf("-")))) {
                throw new IllegalArgumentException(ErrorMessageType.INVALID_MENU_VALUE.getMessage());
            }
        }
    }

    public void validateMenuValue(List<String> menuNames) {
        boolean valueError = true;
        for (String foodMenu : Menu.foodMenuItems()) {
            if (menuNames.contains(foodMenu)) {
                valueError = false;
            }
        }
        if (valueError) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_MENU_VALUE.getMessage());
        }
    }
}