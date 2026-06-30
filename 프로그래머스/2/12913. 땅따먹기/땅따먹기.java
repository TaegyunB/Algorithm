class Solution {
    int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        
        int[][] dp = new int[row][col];
        for (int i=0; i<col; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i=1; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (j == 0) {
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));
                } else if (j == 1) {
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
                } else if (j == 2) {
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3]));
                } else {
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                }
            }
        }
        
        int max = 0;
        for (int i=0; i<col; i++) {
            max = Math.max(max, dp[row-1][i]);
        }
        
        return max;
    }
}