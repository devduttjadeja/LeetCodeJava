import java.util.Arrays;

public class Meeting_Room_252 {
    public static void main(String[] args) {

    }

    // https://walkccc.me/LeetCode/problems/0252/
    public boolean canAttendMeetings(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            // check for overlap if current interval start time is less than previous interval end time
            // then there is overlap
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
