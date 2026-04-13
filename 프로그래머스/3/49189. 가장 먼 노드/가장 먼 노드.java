import java.util.*;

class Solution {
    
    static List<ArrayList<Pos>> tree;
    static int[] cntGraph;
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        
        tree = new ArrayList<>();
        cntGraph = new int[n+1];
        visited = new boolean[n+1];
        
        // tree 선언
        for (int i=0; i<=n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i=0; i<edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            
            tree.get(start).add(new Pos(end, 1));
            tree.get(end).add(new Pos(start, 1));
        }
        
        // 무한대로 선언
        for (int i=1; i<=n; i++) {
            cntGraph[i] = Integer.MAX_VALUE;
        }
        
        Deque<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(1, 0));
        cntGraph[1] = 0;
        visited[1] = true;
        
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            int next = pos.next;
            int cnt = pos.cnt;
            
            for (Pos nextPos : tree.get(next)) {
                int nextNode = nextPos.next;
                
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.offer(new Pos(nextNode, cnt + 1));
                    cntGraph[nextNode] = cnt + 1;
                }   
            }
        }
        
        int maxNum = 0;
        int count = 0;
        for (int i=1; i<=n; i++) {
            if (cntGraph[i] > maxNum) {
                maxNum = cntGraph[i];
                count = 1;
            } else if (cntGraph[i] == maxNum) {
                count++;
            }
        }
        
        return count;
    }
    
    private class Pos {
        int next;
        int cnt;
        
        public Pos(int next, int cnt) {
            this.next = next;
            this.cnt = cnt;
        }
    }
    
    
}