package christmas.data.event;

public class EventParticipationInfo {
    private static int totalParticipationPeople;
    private static long totalSales;

    public EventParticipationInfo(int totalParticipationPeople, long totalSales) {
        this.totalParticipationPeople = totalParticipationPeople;
        this.totalSales = totalSales;
    }
}
