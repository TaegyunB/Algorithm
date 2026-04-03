import java.util.*;

class Solution {
    
    static List<ArrayList<Pos>> tree;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        tree = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i=0; i<roads.length; i++) {
            int start = roads[i][0];
            int end = roads[i][1];
            
            tree.get(start).add(new Pos(end, 1));
            tree.get(end).add(new Pos(start, 1));
        }
        
        int[] result = dijkstra(n, destination);
        
        for (int i=0; i<sources.length; i++) {
            int idx = sources[i];
        
            if (result[idx] == Integer.MAX_VALUE) {
                answer[i] = -1;
            } else {
                answer[i] = result[idx];   
            }
        }
        
        return answer;
    }
    
    private int[] dijkstra(int n, int destination) {
        int[] dists = new int[n+1];
        
        for (int i=0; i<=n; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
        
        dists[destination] = 0;
        
        Queue<Pos> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        q.offer(new Pos(destination, 0));
        
        while(!q.isEmpty()) {
            Pos pos = q.poll();
            int start = pos.next;
            int dist = pos.dist;
            
            for (Pos nextPos : tree.get(start)) {
                int nextStart = nextPos.next;
                int nextDist = nextPos.dist;
                
                if (dist + nextDist < dists[nextStart]) {
                    dists[nextStart] = dist + nextDist;
                    q.offer(new Pos(nextStart, dist + nextDist));
                }
            }
        }
        
        return dists;
    }
    
    
    static class Pos {
        int next;
        int dist;
        
        public Pos(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }
    
    
}