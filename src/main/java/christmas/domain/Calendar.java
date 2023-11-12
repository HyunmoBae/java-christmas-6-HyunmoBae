package christmas.domain;

import java.util.List;

public class Calendar {
    List<Integer> weekday = List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31);
    List<Integer> weekend = List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
    List<Integer> specialDay = List.of(3, 10, 17, 24, 25, 31);

    public List<String> isDay(int date) {
        if (weekday.contains(date) && specialDay.contains(date)) {
            return List.of("weekday", "specialDay");
        } else if (weekday.contains(date)) {
            return List.of("weekday");
        } else if (weekend.contains(date)) {
            return List.of("weekend");
        } else if (specialDay.contains(date)) {
            return List.of("specialDay");
        }
        return null;
    }

}
