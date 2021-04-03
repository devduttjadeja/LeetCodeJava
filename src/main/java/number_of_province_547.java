import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class number_of_province_547 {

    public int findCircleNum(int[][] isConnected) {

        Set<Integer> visited = new HashSet<>();
        int count = 0;
        int numOfVertex = isConnected.length;

        for (int i = 0; i < numOfVertex; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, Set<Integer> visited) {

        visited.add(i);
        for (int j = 0; j < isConnected[i].length; j++) {
            if (i != j && !visited.contains(j) && isConnected[i][j] == 1) {
                dfs(isConnected, j, visited);
            }
        }
    }
}
