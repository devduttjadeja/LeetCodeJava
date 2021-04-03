public class UniquePath_62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int row, int col) {
        int[][] grid = new int[row][col];
        int value = callDFS(0, 0, row, col, grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println(""+(i+1)+":"+(j+1)+"-->"+grid[i][j]);
            }
            System.out.println();
        }
        return value;
    }

    public static int callDFS(int i, int j, int row, int col, int[][] grid) {

        if (i == row - 1 && j == col - 1) {
            return 1;
        }

        if (i < 0 || i >= row || j < 0 || j >= col) {
            return 0;
        }

        // if there are already some ways to reach the grid then return that value
        if (grid[i][j] != 0) {
            return grid[i][j];
        }

        grid[i][j] = callDFS(i + 1, j, row, col, grid) + callDFS(i, j + 1, row, col, grid);

        return grid[i][j];
    }
}
