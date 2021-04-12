import java.util.*;

public class CourseSchedule_II_210 {
    public static void main(String[] args) {

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        // https://www.youtube.com/watch?v=qe_pQCh09yU
        // Time: O(|V| + |E|)
        // Space: O(|V| + |E|)

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

        // stack to maintain order of topological sort
        Stack<Integer> stack = new Stack<>();

        // Do DFS for each of the array nodes [0 to numCourses-1] and  check a cycle
        for (int i = 0; i < numCourses; i++) {
            // if dfs started form any node "i" return false it means there is a cycle
            if (!dfs(i, visited, map, stack)) {
                return new int[]{};
            }
        }

        int index = 0;
        int[] result = new int[stack.size()];
        while (!stack.isEmpty()){
            result[index] = stack.pop();
            index++;
        }
        return result;
    }

    private static boolean dfs(int currentNode, int[] visited, Map<Integer, List<Integer>> map, Stack<Integer> stack) {

        // Return false if the currentNode is "in progress"
        if (visited[currentNode] == 1) {
            return false;
        }

        // Return true if the currentNode is "visited"
        if (visited[currentNode] == 2) {
            return true;
        }

        // Mark the node as "in progress"
        visited[currentNode] = 1;

        // DFS of all the adjacentNode
        if (map.get(currentNode) != null) {
            for (int adjacentNode : map.get(currentNode)) {
                if (!dfs(adjacentNode, visited, map, stack)) {
                    return false;
                }
            }
        }

        // If no more other nodes for the current "node" mark as visited and return true
        visited[currentNode] = 2;
        stack.push(currentNode);
        return true;
    }
}
