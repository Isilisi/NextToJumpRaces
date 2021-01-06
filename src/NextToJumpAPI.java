import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextToJumpAPI {

    private String dataFilePath = "Data/Sample.csv";

    public NextToJumpAPI() {}

    public List<Race> getNextRaces() {
        return getNextRaces(LocalTime.now(), 10);
    }

    public List<Race> getNextRaces(LocalTime currentTime, int n) {
        List<Race> allRaces = readRaces();
        List<Race> nextRaces = new ArrayList<>();
        for (Race race : allRaces) {
            if (race.startTime.isAfter(currentTime)) {
                nextRaces.add(race);
            }
        }
        Collections.sort(nextRaces, (r1, r2) -> r1.startTime.compareTo(r2.startTime));

        if (n >= nextRaces.size()) {
            return nextRaces;
        }
        return nextRaces.subList(0, n);
    }

    private List<Race> readRaces() {
        List<Race> raceList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.dataFilePath))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                for (int i = 0; i < values.length; ++i) {
                    if (values[i].equals("")) {
                        values[i] = null;
                    }
                }

                raceList.add(new Race(
                        values[0],
                        values[1],
                        values[2],
                        values[3],
                        LocalTime.parse(values[4], DateTimeFormatter.ofPattern("H.mm"))));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return raceList;
    }
}
