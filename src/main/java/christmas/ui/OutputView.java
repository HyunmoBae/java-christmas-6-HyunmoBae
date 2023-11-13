package christmas.ui;

import christmas.domain.Event;

public class OutputView {

    public void printHello() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printNotice() {
        System.out.println("<주의사항>");
        System.out.println("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
        System.out.println("음료만 주문 시, 주문이 불가능합니다.");
        System.out.println("메뉴는 한번에 최대 20개까지만 주문가능합니다.");
        System.out.println("(e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)\n");
    }

    public void printMenu(Event event) {
        System.out.println("12월 " + event.getDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");

        for (String menuOrder : event.getMenuOrders()) {
            System.out.println(event.getOrderedMenuName(menuOrder) + " " + event.getOrderedMenuCount(menuOrder) + "개");
        }
        System.out.println();
    }

    public void printTotalAmountBeforeDiscount(Event event) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format("%,d", event.getTotalAmountBeforeDiscount()) + "원\n");
    }

    public void printTotalAmountAfterDiscount(Event event) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(
                String.format("%,d", event.getTotalAmountAfterDiscount(event.getTotalAmountBeforeDiscount())) + "원\n");
    }

    public void printGiftMenu(Event event) {
        System.out.println("<증정 메뉴>");
        System.out.println(event.isGiftEvent(event.getTotalAmountBeforeDiscount()) + "\n");
    }

    public void printEventHistory(Event event) {
        System.out.println("<혜택 내역>");
        if (event.getTotalAmountBeforeDiscount() >= 120000) {
            System.out.println("증정 이벤트 : " + String.format("%,d", -25000) + "원");
            printAllDiscount(event);
        } else if (event.getTotalAmountBeforeDiscount() >= 10000) {
            printAllDiscount(event);
        } else if (event.getTotalAmountBeforeDiscount() < 10000) {
            System.out.println("없음\n");
        }
    }

    public void printAllDiscount(Event event) {
        if (event.getChristmasDdayDiscount() != 0) {
            System.out.println("크리스마스 디데이 할인: -" + String.format("%,d", event.getChristmasDdayDiscount()) + "원");
        }
        if (event.getWeekDayDiscount() != 0) {
            System.out.println("평일 할인 : -" + String.format("%,d", event.getWeekDayDiscount()) + "원");
        }
        if (event.getWeekendDiscount() != 0) {
            System.out.println("주말 할인 : -" + String.format("%,d", event.getWeekendDiscount()) + "원");
        }
        if (event.getSpecialDiscount() != 0) {
            System.out.println("특별 할인 : -" + String.format("%,d", event.getSpecialDiscount()) + "원\n");
        }
    }

    public void printTotalDiscount(Event event) {
        System.out.println("<총혜택 금액>");
        if (event.getTotalAmountBeforeDiscount() >= 120000) {
            System.out.println("-" + String.format("%,d", event.getTotalDiscount()) + "원\n");
        } else if (event.getTotalAmountBeforeDiscount() < 10000) {
            System.out.println("0원\n");
        } else if (event.getTotalAmountBeforeDiscount() < 120000) {
            System.out.println("-" + String.format("%,d", Integer.valueOf(event.getTotalDiscount())) + "원\n");
        }
    }

    public void printEventBadge(Event event) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(event.getEventBadge(event.getTotalDiscount()));
    }

}