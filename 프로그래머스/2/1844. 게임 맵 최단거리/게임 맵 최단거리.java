import java.util.*;

class Solution {
    
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static boolean[][] visited;
    static int n, m;
    
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        return bfs(maps, 0, 0);
        
    }
    
    static int bfs(int[][] maps, int startx, int starty)  {
        Deque<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(startx, starty, 1));
        visited[startx][starty] = true;
        
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            int x = pos.x;
            int y = pos.y;
            int dist = pos.dist;
            
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx == n-1 && ny == m-1) {
                    return dist+1;
                }
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Pos(nx, ny, dist+1));
                }
            }
        }
        
        return -1;
    }
    
    static class Pos {
        int x;
        int y;
        int dist;
        
        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}