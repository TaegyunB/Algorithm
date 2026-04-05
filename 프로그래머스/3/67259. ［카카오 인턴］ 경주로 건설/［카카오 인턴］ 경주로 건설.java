import java.util.*;

class Solution {
    
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[][][] costs;
    static int h;
    static int w;
    
    public int solution(int[][] board) {
        
        h = board.length;
        w = board[0].length;
        costs = new int[h][w][4];
        
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                for (int k=0; k<4; k++) {
                    costs[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int i=0; i<4; i++) {
            costs[0][0][i] = 0;    
        }
        return bfs(0, 0, board);
    }
    
    private int bfs(int x, int y, int[][] board) {
        Queue<Pos> q = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        
        for (int i=0; i<4; i++) {
            q.offer(new Pos(x, y, i, 0));
        }
        
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            int cx = pos.x;
            int cy = pos.y;
            int cDir = pos.dir;
            int cCost = pos.cost;
            
            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nextCost = 0;
                
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }
                
                if (board[nx][ny] == 1) {
                    continue;
                }
                
                if (cDir == i) {
                    nextCost = cCost + 100;
                } else {
                    nextCost = cCost + 500 + 100;
                }
                
                if (nextCost <= costs[nx][ny][i]) {
                    costs[nx][ny][i] = nextCost;
                    q.offer(new Pos(nx, ny, i, nextCost));
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i=0; i<4; i++) {
            if (costs[h-1][w-1][i] < answer) {
                answer = costs[h-1][w-1][i];
            }
        }
        return answer;
    }
    
    static class Pos {
        int x;
        int y;
        int dir;
        int cost;
        
        public Pos(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
}