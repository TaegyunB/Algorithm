// dp를 여기까지 도달하는 경로가 몇 가지인지를 더해서 누적하는 구조로 구성해야함

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        
        boolean[][] isWater = new boolean[n][m];
        int[][] dp = new int[n][m];
        
        // 물에 잠긴 곳 -1로 지정
        for (int[] puddle : puddles) {
            int x = puddle[0] - 1;
            int y = puddle[1] - 1;
            
            isWater[y][x] = true;
        }
        
        // 시작 dp는 경로 1개
        dp[0][0] = 1;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                // 물에 잠겨 있을 시 그냥 지나감
                if (isWater[i][j]) {
                    continue;
                }
                
                // 오른쪽 칸으로 경로 수 누적 (범위 안 + 물에 잠겨 있지 않을 때)
                if (j+1 < m && !isWater[i][j+1]) {
                    dp[i][j+1] = (dp[i][j+1] + dp[i][j]) % 1000000007;
                }
                
                // 왼쪽 칸으로 경로 수 누적 (범위 안 + 물에 잠겨 있지 않을 때)
                if (i+1 < n && !isWater[i+1][j]) {
                    dp[i+1][j] = (dp[i+1][j] + dp[i][j]) % 1000000007;
                }
            }
        }
        
        // 마지막 칸의 수가 최단경로의 수
        return dp[n-1][m-1];
    }
}