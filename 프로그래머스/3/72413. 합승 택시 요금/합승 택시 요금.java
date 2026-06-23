// 플로이드-워셜 알고리즘
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int[][] graph = new int[n+1][n+1];
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int i=0; i<fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int dist = fares[i][2];
            
            graph[start][end] = dist;
            graph[end][start] = dist;
        }
        
        // 모든 지점 쌍 사이의 최단거리 구하기
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        // 합승 지점별로 합쳐서 비교
        for (int i=1; i<=n; i++) {
                if (graph[s][i] == Integer.MAX_VALUE || graph[i][a] == Integer.MAX_VALUE || graph[i][b] == Integer.MAX_VALUE) {
                    continue;
                }
            
            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }
        
        return answer;
    }
}