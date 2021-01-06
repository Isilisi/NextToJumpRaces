import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NextToJumpAPI {

    public NextToJumpAPI() {}

    public List<Race> getNextRaces() {
        return readRaces();
    }
    public List<Race> getNextRaces(LocalTime currentTime, int n) {
        return readRaces();
    }

    private List<Race> readRaces() {
        List<Race> raceList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Data/Sample.csv"))) {
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
