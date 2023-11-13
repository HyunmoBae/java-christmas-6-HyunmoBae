package christmas.data.reservation;

import java.util.List;

public class ReservationInfo {
    private static String name;
    private static int totalAmountBeforeDiscount;
    private static int totalAmountAfterDiscount;
    private static int date;
    private static int totalDiscount;
    private static String gift;
    private static List<String> menuOrders;

    public ReservationInfo(String name, int totalAmountBeforeDiscount, int totalAmountAfterDiscount, int date,
                           int totalDiscount, String gift, List<String> menuOrders) {
        this.name = name;
        this.totalAmountBeforeDiscount = totalAmountBeforeDiscount;
        this.totalAmountAfterDiscount = totalAmountAfterDiscount;
        this.date = date;
        this.totalDiscount = totalDiscount;
        this.gift = gift;
        this.menuOrders = menuOrders;
    }

}
