class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n+1][n+1];
        
        for (int i=0; i<results.length; i++) {
            int perWin = results[i][0];
            int perLose = results[i][1];
            
            win[perWin][perLose] = true;
        }
        
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i=1; i<=n; i++) {
            int cnt = 0;
            
            for (int j=1; j<=n; j++) {
                if (win[i][j] || win[j][i]) {
                    cnt++;
                }
            }
            
            if (cnt == n-1) {
               answer++; 
            }
        }
        
        return answer;
        
    }
}