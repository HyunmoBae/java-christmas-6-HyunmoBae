package christmas.data.person;

import christmas.data.reservation.ReservationInfo;
import java.util.List;

public class PersonInfo {
    private static String name;
    private static List<ReservationInfo> reservationInfo;
    private static String eventBadge;

    public PersonInfo(String name, List<ReservationInfo> reservationInfo, String eventBadge) {
        this.name = name;
        this.reservationInfo = reservationInfo;
        this.eventBadge = eventBadge;
    }
}
