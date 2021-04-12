import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule_207 {
    public static void main(String[] args) {

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // https://www.youtube.com/watch?v=kXy0ABd1vwo --> only for logic
        // Time: O(|V| + |E|), where |V| = numCourses and |E| = len(prerequisites)
        // Space: O(|V| + |E|), where |V| = numCourses and |E| = len(prerequisites)

        // created "directed graph"
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] arr : prerequisites) {
            if (map.containsKey(arr[1])) {
                map.get(arr[1]).add(arr[0]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[0]);
                map.put(arr[1], temp);
            }
        }

        // Define an array of visited (0 -> unvisited, 1 -> in progress, 2 -> visited), initially filled with 0's
        int[] visited = new int[numCourses];

        // Do DFS for each of the array nodes [0 to numCourses-1] and  check a cycle
        for (int i = 0; i < numCourses; i++) {
            // if dfs started form any node "i" return false it means there is a cycle
            if (!dfs(i, visited, map)) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(int currentNode, int[] visited, Map<Integer, List<Integer>> map) {


        visited[currentNode] = 1; // mark the current node as in progress

        // traveres all adjacent node of current node

        if (map.get(currentNode) != null) {
            for (int adjacentNode : map.get(currentNode)) {

                // if any adjacent node is "in progress", that means there is a cycle
                if (visited[adjacentNode] == 1) {
                    return false;
                }

                // adjacent node is "unvisted" then do dfs form that node
                if (visited[adjacentNode] == 0) {
                    if (!dfs(adjacentNode, visited, map)) {
                        return false;
                    }
                }
            }
        }

        // mark as completed
        visited[currentNode] = 2;

        return true;
    }
}
