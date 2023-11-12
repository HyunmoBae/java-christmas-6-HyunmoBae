package christmas.data.event;

import christmas.data.person.PersonInfo;
import java.util.List;

public class EventParticipationInfo {
    private static List<PersonInfo> personInfo;
    private static int totalParticipationPeople;
    private static long totalSales;

    public EventParticipationInfo(List<PersonInfo> personInfo, int totalParticipationPeople, long totalSales) {
        this.personInfo = personInfo;
        this.totalParticipationPeople = totalParticipationPeople;
        this.totalSales = totalSales;
    }
}
