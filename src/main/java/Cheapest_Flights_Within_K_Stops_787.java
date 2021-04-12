import java.util.*;

public class Cheapest_Flights_Within_K_Stops_787 {
    public static void main(String[] args) {

    }

    public int findCheapestPrice(int n, int[][] flights, int source, int destination, int K) {

        // key = source
        // value destination, distance to destination = List<int[]> [3,100] [2,56] [1,45]
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // index 0 --> cost from source to current
        // index 1 --> current
        // indes 2 --> remaining stops
        heap.add(new int[]{0, source, K});

        while (!heap.isEmpty()) {

            int[] node = heap.poll();

            int distanceToCurrent = node[0];
            int current = node[1];
            int remainingStop = node[2];

            if (current == destination) {
                return distanceToCurrent;
            }

            if (remainingStop >= 0) {

                List<int[]> adjacentNodes = map.get(current);

                // adjacentNode[0] --> node
                // adjacentNode[1] --> distance
                if (adjacentNodes != null) {
                    for (int[] adjacentNode : adjacentNodes) {
                        heap.offer(new int[]{distanceToCurrent + adjacentNode[1], adjacentNode[0], remainingStop - 1});
                    }
                }

            }
            
        }

        return -1;
    }
}
