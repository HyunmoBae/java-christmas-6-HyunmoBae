package christmas.domain;

import christmas.common.Menu.Appetizer;
import christmas.common.Menu.Beverage;
import christmas.common.Menu.Dessert;
import christmas.common.Menu.MainDish;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private int date = 0;
    private List<String> menuOrders = new ArrayList<>();
    private int totalDiscount = 0;
    private String badge = "";

    Calendar calendar = new Calendar();

    public Event(String name, int date, List<String> menuOrders) {
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
            christmasDdayDiscount();
            weekDayDiscount();
            weekendDiscount();
            specialDiscount();
            getEventBadge();
        }
    }

    public String christmasDdayDiscount() {
        if (date <= 25) {
            totalDiscount += ((date - 1) * 100) + 1000;
            return String.format("%,d", ((date - 1) * 100) + 1000);
        }
        return null;
    }

    public String weekDayDiscount() {
        if (calendar.isDay(date).contains("weekday")) {
            totalDiscount += getDessertCountAndPrice().get(0) * 2023;
            return String.format("%,d", getDessertCountAndPrice().get(0) * 2023);
        }
        return null;
    }

    public String weekendDiscount() {
        if (calendar.isDay(date).contains("weekend")) {
            totalDiscount += getMainDishCountAndPrice().get(0) * 2023;
            return String.format("%,d", getMainDishCountAndPrice().get(0) * 2023);
        }
        return null;
    }

    public String specialDiscount() {
        if (calendar.isDay(date).contains("specialDay")) {
            totalDiscount += 1000;
            return String.format("%,d", 1000);
        }
        return null;
    }

    public String isGiftEvent(int totalAmountBeforeDiscount) {
        if (totalAmountBeforeDiscount >= 120000) {
            return "샴페인";
        }
        return "없음";
    }

    public void getEventBadge() {
        if (totalDiscount >= 20000) {
            this.badge = "산타";
        } else if (totalDiscount >= 10000) {
            this.badge = "트리";
        } else if (totalDiscount >= 5000) {
            this.badge = "별";
        } else if (totalDiscount < 5000) {
            this.badge = "없음";
        }
    }

    private String getOrderedMenuName(String menuOrder) {
        String menuName = menuOrder.substring(0, menuOrder.indexOf("-"));
        return menuName;
    }

    private int getOrderedMenuCount(String menuOrder) {
        int countIndex = Integer.valueOf(menuOrder.indexOf("-") + 1);
        int menuCount = Integer.valueOf(menuOrder.substring(countIndex));
        return menuCount;
    }

    public String getTotalDiscount() {
        return String.format("%,d", totalDiscount);
    }

    public String getBadge() {
        return badge;
    }

}
