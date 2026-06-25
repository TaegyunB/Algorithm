import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        
        answer = 0;
        // Arrays.sort(dungeons, (a, b) -> a[1] - b[1]);
        
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        
        return answer;
    }
    
    // 재귀 - 백트래킹
    private void dfs(int k, int[][] dungeons, boolean[] visited, int cnt) {
        answer = Math.max(answer, cnt);
        
        for (int i=0; i<dungeons.length; i++) {
            int need = dungeons[i][0];  // 최소 필요 피로도
            int used = dungeons[i][1];  // 소모 피로도
            
            if (k >= need && !visited[i]) {
                visited[i] = true;
                dfs(k - used, dungeons, visited, cnt+1);
                visited[i] = false;  // 백트래킹
            }
        }
    }
}