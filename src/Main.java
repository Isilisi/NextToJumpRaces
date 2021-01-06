import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        NextToJumpAPI ntj = new NextToJumpAPI();
        System.out.println(ntj.getNextRaces(LocalTime.parse("11:53"), 2));
        System.out.println(ntj.getNextRaces());
    }
}