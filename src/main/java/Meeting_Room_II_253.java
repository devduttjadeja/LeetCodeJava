import java.util.Arrays;
import java.util.PriorityQueue;

public class Meeting_Room_II_253 {

    public static void main(String[] args) {

    }

    public int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 0 || intervals == null) {
            return 0;
        }

        // priority queue to sort end times of each room
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // sort as per start times
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        for (int[] interval : intervals) {

            // if queue is not empty and
            // current interval's start time is more than the meeting with earliest end time
            // it means there is no overlap and we can use same room
            // we need to update the earliest end time, so remove old meeting with earliest end time
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
                minHeap.poll(); // minHeap.remove();
            }
            // add current meetings end time
            minHeap.offer(interval[1]); // minHeap.add();
        }

        return minHeap.size();
    }
}
