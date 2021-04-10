public class UniquePath_63 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePaths2(grid));
    }

    public static int uniquePaths2(int[][] grid) {

        // https://www.youtube.com/watch?v=z6kelCB0ww4

        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];

        // EDGE CASE when start point is obstcale return 0;
        if (grid[0][0] == 1) {
            return 0;
        }

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                // one way to reach cell 0,0 from 0,0
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }

                // for first row , if there is no obscatale then its '1'
                // otherwise all the elements after the obsctale are '0'
                // see video for clarification
                if (i == 0 && j > 0) {
                    if (grid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }

                // for first col , if there is no obscatale then its '1'
                // otherwise all the elements after the obsctale are '0'
                // see video for clarification
                if (j == 0 && i > 0) {
                    if (grid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

                if (i > 0 && j > 0) {

                    if (grid[i][j] == 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else {
                        // when obactle there is no way through it so '0'
                        dp[i][j] = 0;
                    }
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}
