public class UniquePath_63 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println(uniquePaths2(grid)/10);

    }

    public static int uniquePaths2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int value = callDFS(0, 0, row, col, grid);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println(""+(i+1)+":"+(j+1)+"-->"+grid[i][j]);
            }
            System.out.println();
        }
        return value;
    }

    private static int callDFS(int i, int j, int row, int col, int[][] grid) {

        if (i == row - 1 && j == col - 1) {
            if (grid[i][j] == 1) {
                return 0;
            } else {
                return 10;
            }
        }

        if (i < 0 || i >= row || j < 0 || j >= col) {
            return 0;
        }

        if (grid[i][j] == 1) {
            return 0;
        }

        // if there are already some ways to reach the grid
        // grid[i][j] = number of ways to reach the destination from cell i, j
        if (grid[i][j] != 0) {
            return grid[i][j];
        }

        // number of ways to reach destination from cell i, j = sum of number of ways to reach from cell (i+1,j) + (i,j+1)
        grid[i][j] = callDFS(i + 1, j, row, col, grid) + callDFS(i, j + 1, row, col, grid);

        return grid[i][j];
    }
}
