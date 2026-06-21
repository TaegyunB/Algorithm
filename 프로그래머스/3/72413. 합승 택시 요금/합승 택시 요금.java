import java.util.*;

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
        
        // 플로이드 워셜
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (i == j) {
                        continue;
                    }
                    
                    if (graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int k=1; k<=n; k++) {
            if (graph[s][k] == Integer.MAX_VALUE || graph[k][a] == Integer.MAX_VALUE || graph[k][b] == Integer.MAX_VALUE) {
                continue;
            }
            
            // 출발지에서 함께 가는 지점 + a, b 각각 따로 가는 시점 중에서 가장 짧게 걸리는 값 구하기
            answer = Math.min(answer, graph[s][k] + graph[k][a] + graph[k][b]);
        }
        
        return answer;
    }
}