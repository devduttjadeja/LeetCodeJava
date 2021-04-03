import java.text.ParseException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SpareLabs {

    public static void main(String[] args) throws ParseException {

        String[] input1 = new String[]{"12:15PM-02:00PM", "09:00AM-10:00AM", "10:30AM-12:00PM"};
        String[] input2 = new String[]{"12:15PM-02:00PM", "09:00AM-12:11PM", "02:02PM-04:00PM"};
        List<String[]> data = new ArrayList<>();

        for (String event : input1) {
            String[] timeslots = event.split("-");
            String start = LocalTime.parse(timeslots[0], DateTimeFormatter.ofPattern("hh:mma", Locale.US)).format(DateTimeFormatter.ofPattern("HH:mm"));
            String end = LocalTime.parse(timeslots[1], DateTimeFormatter.ofPattern("hh:mma", Locale.US)).format(DateTimeFormatter.ofPattern("HH:mm"));
            data.add(new String[]{start, end});
        }

        System.out.println(freeSlots(data));
    }

    public static String freeSlots(List<String[]> intervals) {
        List<String[]> res = new ArrayList<>();
        List<LocalTime[]> times = new ArrayList<>();
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("H:mm");

        // convert to time for simplicity
        for (String[] time : intervals) {
            times.add(new LocalTime[]{LocalTime.parse(time[0], tf), LocalTime.parse(time[1], tf)});
        }

        // sort by start times
        times.sort((a, b) -> a[0].compareTo(b[0]));

        long max = 0;
        for (int i = 1; i < times.size(); i++) {
            Duration duration = Duration.between(times.get(i - 1)[1], times.get(i)[0]);
            max = Math.max(max, duration.getSeconds());
        }

        long p2 = max / 60;
        long p3 = p2 % 60;
        p2 = p2 / 60;

        String a2 = p2 < 10 ? "0" + p2 : "" + p2;
        String a3 = p3 < 10 ? "0" + p3 : "" + p3;

        return a2 + ":" + a3;
    }
}
