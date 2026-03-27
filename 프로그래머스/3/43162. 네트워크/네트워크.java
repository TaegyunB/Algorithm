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
    
    // 얼마나 더 깊이 연결되어 있는지 확인하게 위해 dfs 사용
    private void dfs(int node) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(node);
        visited[node] = true;
        
        while (!stack.isEmpty()) {
            int startNode = stack.pop();
            
            for (int nextNode : list.get(startNode)) {
                if (!visited[nextNode]) {
                    stack.push(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}