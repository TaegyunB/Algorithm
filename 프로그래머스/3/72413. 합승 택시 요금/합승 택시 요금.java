import java.util.*;

class Solution {

    static List<ArrayList<Pos>> tree;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        tree = new ArrayList<>();
        
        for (int i=0; i<=n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i=0; i<fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int dist = fares[i][2];
            
            tree.get(start).add(new Pos(end, dist));
            tree.get(end).add(new Pos(start, dist));
        }
        
        int[] distS = dijkstra(n, s);
        int[] distA = dijkstra(n, a);
        int[] distB = dijkstra(n, b);
        
        int answer = Integer.MAX_VALUE;
        
        for (int i=1; i<=n; i++) {
            // 오버플로우 방지
            if (distS[i] == Integer.MAX_VALUE || distA[i] == Integer.MAX_VALUE || distB[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            int sum = distS[i] + distA[i] + distB[i];
            
            if (sum < answer) {
                answer = sum;
            }
        }
        
        return answer;
    }
    
    private int[] dijkstra(int n, int s) {
        
        int[] dists = new int[n+1];

        for (int i=0; i<=n; i++) {
            dists[i] = Integer.MAX_VALUE;
        }
        
        dists[s] = 0;
        
        // 다익스트라이기 때문에 PQ 사용
        Queue<Pos> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        q.offer(new Pos(s, 0));
        
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            int start = pos.next;
            int dist = pos.dist;
            
            for (Pos nextPos : tree.get(start)) {
                int nextNode = nextPos.next;
                int nextDist = nextPos.dist;
                
                if (dist + nextDist < dists[nextNode]) {
                    dists[nextNode] = dist + nextDist;
                    q.offer(new Pos(nextNode, dist + nextDist));
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