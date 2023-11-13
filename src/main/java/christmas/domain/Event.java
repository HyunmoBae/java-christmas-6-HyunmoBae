package christmas.domain;

import christmas.common.Menu.Appetizer;
import christmas.common.Menu.Beverage;
import christmas.common.Menu.Dessert;
import christmas.common.Menu.MainDish;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private static int date;
    private static List<String> menuOrders = new ArrayList<>();

    private int totalDiscount = 0;
    private int totalBenefitAmount = 0;

    Calendar calendar = new Calendar();

    public Event(String name, int date, List<String> menuOrders) {
        this.date = date;
        this.menuOrders = menuOrders;
        isEvent(getTotalAmountBeforeDiscount());
    }

    public Event(int date, List<String> menuOrders) {
        this.date = date;
        this.menuOrders = menuOrders;
        isEvent(getTotalAmountBeforeDiscount());
    }

    public int getTotalAmountBeforeDiscount() {
        int totalAmountBeforeDiscount = getAppetizerCountAndPrice().get(1) + getMainDishCountAndPrice().get(1)
                + getDessertCountAndPrice().get(1) + getBeverageCountAndPrice().get(1);
        return totalAmountBeforeDiscount;
    }

    public int getTotalAmountAfterDiscount(int totalAmountBeforeDiscount) {
        int totalAmountAfterDiscount = totalAmountBeforeDiscount - totalDiscount;
        return totalAmountAfterDiscount;
    }

    private List<Integer> getAppetizerCountAndPrice() {
        int totalCount = 0;
        int totalPrice = 0;
        for (String menuOrder : menuOrders) {
            try {
                Appetizer appetizer = Appetizer.valueOf(getOrderedMenuName(menuOrder));
                totalPrice += appetizer.getPrice() * getOrderedMenuCount(menuOrder);
                totalCount += getOrderedMenuCount(menuOrder);
            } catch (IllegalArgumentException e) {
            }
        }
        List<Integer> appetizerInfo = List.of(totalCount, totalPrice);
        return appetizerInfo;
    }

    private List<Integer> getMainDishCountAndPrice() {
        int totalCount = 0;
        int totalPrice = 0;
        for (String menuOrder : menuOrders) {
            try {
                MainDish mainDish = MainDish.valueOf(getOrderedMenuName(menuOrder));
                totalPrice += mainDish.getPrice() * getOrderedMenuCount(menuOrder);
                totalCount += getOrderedMenuCount(menuOrder);
            } catch (IllegalArgumentException e) {
            }
        }
        List<Integer> mainDishInfo = List.of(totalCount, totalPrice);
        return mainDishInfo;
    }

    private List<Integer> getDessertCountAndPrice() {
        int totalCount = 0;
        int totalPrice = 0;
        for (String menuOrder : menuOrders) {
            try {
                Dessert dessert = Dessert.valueOf(getOrderedMenuName(menuOrder));
                totalPrice += dessert.getPrice() * getOrderedMenuCount(menuOrder);
                totalCount += getOrderedMenuCount(menuOrder);
            } catch (IllegalArgumentException e) {
            }
        }
        List<Integer> dessertInfo = List.of(totalCount, totalPrice);
        return dessertInfo;
    }

    private List<Integer> getBeverageCountAndPrice() {
        int totalCount = 0;
        int totalPrice = 0;
        for (String menuOrder : menuOrders) {
            try {
                Beverage beverage = Beverage.valueOf(getOrderedMenuName(menuOrder));
                totalPrice += beverage.getPrice() * getOrderedMenuCount(menuOrder);
                totalCount += getOrderedMenuCount(menuOrder);
            } catch (IllegalArgumentException e) {
            }
        }
        List<Integer> beverageInfo = List.of(totalCount, totalPrice);
        return beverageInfo;
    }

    private void isEvent(int totalAmountBeforeDiscount) {
        if (totalAmountBeforeDiscount >= 10000) {
            giftEvent(totalAmountBeforeDiscount);
            christmasDdayDiscount();
            weekDayDiscount();
            weekendDiscount();
            specialDiscount();
        }
    }

    public void christmasDdayDiscount() {
        if (date <= 25) {
            totalDiscount += ((date - 1) * 100) + 1000;
            totalBenefitAmount += ((date - 1) * 100) + 1000;
        }
    }

    public int getChristmasDdayDiscount() {
        if (date <= 25) {
            return ((date - 1) * 100) + 1000;
        }
        return 0;
    }

    public void weekDayDiscount() {
        if (calendar.isDay(date).contains("weekday")) {
            totalDiscount += getDessertCountAndPrice().get(0) * 2023;
            totalBenefitAmount += getDessertCountAndPrice().get(0) * 2023;
        }
    }

    public int getWeekDayDiscount() {
        if (calendar.isDay(date).contains("weekday")) {
            return getDessertCountAndPrice().get(0) * 2023;
        }
        return 0;
    }

    public void weekendDiscount() {
        if (calendar.isDay(date).contains("weekend")) {
            totalDiscount += getMainDishCountAndPrice().get(0) * 2023;
            totalBenefitAmount += getMainDishCountAndPrice().get(0) * 2023;
        }
    }

    public int getWeekendDiscount() {
        if (calendar.isDay(date).contains("weekend")) {
            return getMainDishCountAndPrice().get(0) * 2023;
        }
        return 0;
    }

    public void specialDiscount() {
        if (calendar.isDay(date).contains("specialDay")) {
            totalDiscount += 1000;
            totalBenefitAmount += 1000;
        }
    }

    public int getSpecialDiscount() {
        if (calendar.isDay(date).contains("specialDay")) {
            return 1000;
        }
        return 0;
    }

    public void giftEvent(int totalAmountBeforeDiscount) {
        if (totalAmountBeforeDiscount >= 120000) {
            totalBenefitAmount += 25000;
        }
    }

    public String getGiftEvent(int totalAmountBeforeDiscount) {
        if (totalAmountBeforeDiscount >= 120000) {
            return "샴페인 1개";
        }
        return "없음";
    }

    public String getEventBadge() {
        if (totalBenefitAmount >= 20000) {
            return "산타";
        } else if (totalBenefitAmount >= 10000) {
            return "트리";
        } else if (totalBenefitAmount >= 5000) {
            return "별";
        }
        return "없음";
    }

    public String getOrderedMenuName(String menuOrder) {
        String menuName = menuOrder.substring(0, menuOrder.indexOf("-"));
        return menuName;
    }

    public int getOrderedMenuCount(String menuOrder) {
        int countIndex = Integer.valueOf(menuOrder.indexOf("-") + 1);
        int menuCount = Integer.valueOf(menuOrder.substring(countIndex));
        return menuCount;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public int getTotalBenefitAmount() {
        return totalBenefitAmount;
    }

    public int getDate() {
        return date;
    }

    public List<String> getMenuOrders() {
        return menuOrders;
    }
}
