package christmas.data.reservation;

import java.util.List;

public class ReservationInfo {
    private static int totalAmountBeforeDiscount;
    private static int totalAmountAfterDiscount;
    private static int reservationDate;
    private static int totalDiscount;
    private static String gift;
    private static List<String> menuOrders;

    public void Reservation(int totalAmountBeforeDiscount, int totalAmountAfterDiscount, int reservationDate,
                            int totalDiscount, String gift, List<String> menuOrders) {
        this.totalAmountBeforeDiscount = totalAmountBeforeDiscount;
        this.totalAmountAfterDiscount = totalAmountAfterDiscount;
        this.reservationDate = reservationDate;
        this.totalDiscount = totalDiscount;
        this.gift = gift;
        this.menuOrders = menuOrders;
    }


}
