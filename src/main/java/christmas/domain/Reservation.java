package christmas.domain;

import christmas.data.reservation.ReservationInfo;

public class Reservation {

    public void Reservation(String name, Event event) {
        ReservationInfo reservationInfo = new ReservationInfo(name, event.getTotalAmountBeforeDiscount(),
                event.getTotalAmountAfterDiscount(event.getTotalAmountBeforeDiscount()), event.getDate(),
                event.getTotalDiscount(), event.isGiftEvent(event.getTotalAmountBeforeDiscount()),
                event.getMenuOrders());
    }

}
