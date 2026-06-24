class Solution {
    public long solution(int n) {
        long[] dp = new long[n+1];
        
        // 점화식: dp[i] = dp[i-2] + dp[i-1]
        dp[1] = 1;
        if (n == 1) {
            return 1 % 1234567;
        }
        
        dp[2] = 2;
        if (n == 2) {
            return 2 % 1234567;
        }
        
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        return dp[n];
    }
}