package christmas.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {

    public enum Appetizer {
        양송이수프(6000),
        타파스(5500),
        시저샐러드(8000);

        private final int price;

        Appetizer(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public enum MainDish {
        티본스테이크(55000),
        바비큐립(54000),
        해산물파스타(35000),
        크리스마스파스타(25000);

        private final int price;

        MainDish(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public enum Dessert {
        초코케이크(15000),
        아이스크림(5000);

        private final int price;

        Dessert(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public enum Beverage {
        제로콜라(3000),
        레드와인(60000),
        샴페인(25000);

        private final int price;

        Beverage(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public static List<String> foodMenuItems() {
        List<String> foodMenuItems = new ArrayList<>();
        foodMenuItems.add(Arrays.toString(Appetizer.values()));
        foodMenuItems.add(Arrays.toString(MainDish.values()));
        foodMenuItems.add(Arrays.toString(Dessert.values()));
        return foodMenuItems;
    }

}
