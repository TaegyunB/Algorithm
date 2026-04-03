import java.util.*;

class Solution {
    
    static int[] dists;
    static List<ArrayList<Pos>> tree;
    
    public int solution(int N, int[][] road, int K) {
        
        dists = new int[N];
        tree = new ArrayList<>();
        
        for (int i=0; i<N; i++) {
            tree.add(new ArrayList<>());
            dists[i] = Integer.MAX_VALUE;
        }
        
        for (int i=0; i<road.length; i++) {
            int start = road[i][0] - 1;
            int end = road[i][1] - 1;
            int dist = road[i][2];
            
            tree.get(start).add(new Pos(end, dist));
            tree.get(end).add(new Pos(start, dist));
        }
        
        dists[0] = 0;
        dijkstra(0, K);
        
        int answer = 0;
        
        for (int i=0; i<N; i++) {
            if (dists[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 다익스트라는 거리가 짧은 노트부터 꺼내야 하기 때문에 PQ를 사용
    private void dijkstra(int startNode, int K) {
        Queue<Pos> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        
        q.offer(new Pos(startNode, 0));
        
        while(!q.isEmpty()) {
            Pos pos = q.poll();
            int start = pos.end;
            int dist = pos.dist;
            
            for (Pos nextPos : tree.get(start)) {
                int nextNode = nextPos.end;
                int nextDist = nextPos.dist;
                
                if (dist + nextDist <= K && dist + nextDist <= dists[nextNode]) {
                    dists[nextNode] = dist + nextDist;
                    q.offer(new Pos(nextNode, dist + nextDist));
                }
            }
        }   
    }
    
    static class Pos {
        int end;
        int dist;
        
        public Pos(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }
}