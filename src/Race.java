import java.time.LocalTime;

public class Race {

    public final String type;
    public final String number;
    public final String name;
    public final String venue;
    public final LocalTime startTime;

    public Race(String type, String number, String name, String venue, LocalTime startTime) {
        this.type = type;
        this.number = number;
        this.name = name;
        this.venue = venue;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Race{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", venue='" + venue + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
