import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<ArrayList<Integer>> list;
    
    public int solution(int n, int[][] computers) {
        
        list = new ArrayList<>();
        visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) {
                    continue;
                }
                
                if (computers[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }
        
        int cnt = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private void dfs(int node) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;
        
        while (!queue.isEmpty()) {
            int startNode = queue.poll();
            
            for (int nextNode : list.get(startNode)) {
                if (!visited[nextNode]) {
                    queue.offer(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}