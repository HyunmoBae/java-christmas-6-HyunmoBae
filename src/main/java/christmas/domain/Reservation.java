package christmas.domain;

import christmas.data.reservation.ReservationInfo;

public class Reservation {

    public void Reservation(String name, Event event) {
        ReservationInfo reservationInfo = new ReservationInfo(name, event.getTotalAmountBeforeDiscount(),
                event.getTotalAmountAfterDiscount(event.getTotalAmountBeforeDiscount()), event.getDate(),
                event.getTotalDiscount(), event.getGiftEvent(event.getTotalAmountBeforeDiscount()),
                event.getMenuOrders());
        //예약정보 저장하는 부분
    }

}
