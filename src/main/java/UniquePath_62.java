public class UniquePath_62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int row, int col) {
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                // only one way to reach cell 0,0 from 0,0
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }

                // only one way to reach cell in row 0 is from left
                if (i == 0 && j > 0) {
                    dp[i][j] = 1;
                }

                // only one way to reach cells in col 0 is form top
                if (j == 0 && i > 0) {
                    dp[i][j] = 1;
                }

                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}
