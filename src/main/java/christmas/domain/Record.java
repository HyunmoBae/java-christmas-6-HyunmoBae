package christmas.domain;

import christmas.data.event.EventParticipationInfo;
import christmas.data.person.PersonInfo;

public class Record {

    public void createPersonInfo(String name, Event event) {
        PersonInfo personInfo = new PersonInfo(name, event.getEventBadge(event.getTotalDiscount()));
    }

    public void createEventParticipationInfo(int totalPricipationPeople, long totalSales) {
        EventParticipationInfo eventParticipationInfo = new EventParticipationInfo(totalPricipationPeople, totalSales);
    }

}
