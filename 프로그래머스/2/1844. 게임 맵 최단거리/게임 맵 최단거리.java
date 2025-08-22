import java.util.*;

class Solution {
    
    // 위치와 거리 정보를 담는 클래스
    static class Pos {
        int x, y, dist;  // x좌표, y좌표, 시작점부터의 거리
        
        Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int result = bfs(maps, 0, 0, visited, n, m);
        
        return result;
    }
    
    // BFS를 이용한 최단거리 탐색 함수
    private int bfs(int[][] maps, int x, int y, boolean[][] visited, int n, int m) {
        // BFS를 위한 큐 생성
        Queue<Pos> q = new LinkedList<>();
        
        q.offer(new Pos(x, y, 1));
        visited[x][y] = true;
        
        // 쿠가 빌 때까지 반복
        while (!q.isEmpty()) {
            Pos c = q.poll();
            int cx = c.x;
            int cy = c.y;
            int dist = c.dist;
            
            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx == n-1 && ny == m-1) {
                    return dist+1;
                }
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && visited[nx][ny] == false) {
                    q.offer(new Pos(nx, ny, dist + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}
