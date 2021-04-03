public class Number_Of_Islands_200 {

    public static void main(String[] args) {
        char[][] grid = {{'1' , '1' , '0' , '0' , '0' }, {'1' , '1' , '0' , '0' , '0' }, {'0' , '0' , '1' , '0' , '0' }, {'0' , '0' , '0' , '1' , '1' }};
        int answer = numIslands(grid);
        System.out.println(answer);
    }

    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    callDFS(grid, i, j);
                }
            }
        }

        return count;
    }

    public static void callDFS(char[][] grid, int i, int j) {

        // boundary conditions
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        // sink the Island
        grid[i][j] = '0';

        // check in all four sides Top, Down, Left, Right
        callDFS(grid, i - 1, j); // Top
        callDFS(grid, i + 1, j); // Down
        callDFS(grid, i, j - 1); // Left
        callDFS(grid, i, j + 1); // Right
    }
}
