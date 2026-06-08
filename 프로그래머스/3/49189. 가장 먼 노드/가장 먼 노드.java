import java.util.*;

class Solution {
    
    static int n;
    static int[][] edge;
    static boolean[] visited;
    static int[] dists;
    static List<ArrayList<Integer>> tree;
    
    public int solution(int n, int[][] edge) {
        
        n = n;
        edge = edge;
        visited = new boolean[n+1];
        dists = new int[n+1];
        tree = new ArrayList<>();
        
        for (int i=0; i<n+1; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int[] con : edge) {
            int startNode = con[0];
            int endNode = con[1];
            
            tree.get(startNode).add(endNode);
            tree.get(endNode).add(startNode);
        }
        
        bfs(1);   
        
        Arrays.sort(dists);
        int maxNum = dists[n];
        
        int cnt = 1;
        for (int i=1; i<n; i++) {
            if (maxNum == dists[i]) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    static class Pos {
        int node;
        int dist;
        
        public Pos(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    
    static void bfs(int startNode) {
        Deque<Pos> q = new ArrayDeque<>();
        
        q.offer(new Pos(startNode, 0));
        visited[startNode] = true;
        
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            int node = pos.node;
            int dist = pos.dist;
            
            for (int nextNode : tree.get(node)) {
                if (!visited[nextNode]) {
                    int newDist = dist + 1;
                    dists[nextNode] = newDist;
                    q.offer(new Pos(nextNode, newDist));
                    visited[nextNode] = true;
                }
            }
        }
    }
}