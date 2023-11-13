package christmas.domain;

import christmas.data.event.EventParticipationInfo;
import christmas.data.person.PersonInfo;

public class Record {

    public void createPersonInfo(String name, Event event) {
        PersonInfo personInfo = new PersonInfo(name, event.getEventBadge());
        //이벤트 참여자 정보 저장하는 부분
    }

    public void createEventParticipationInfo(int totalPricipationPeople, long totalSales) {
        EventParticipationInfo eventParticipationInfo = new EventParticipationInfo(totalPricipationPeople, totalSales);
        //이벤트 참여 정보 저장하는 부분
    }

}
