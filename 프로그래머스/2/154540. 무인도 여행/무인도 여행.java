import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        int n = maps.length;
        int m = maps[0].length();
        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && map[i][j] != 'X') {
                    visited[i][j] = true;
                    
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    
                    int sum = map[i][j] - '0';
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0];
                        int y = curr[1];
                        
                        for(int k=0; k<4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 'X' && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                sum += map[nx][ny] - '0';
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                   
                    answer.add(sum);
                }
            }
        }
        
        if(answer.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();  // List<Integer>를 int[]로 변환하는 가장 일반적인 문법
        /*
            .mapToInt(i -> i) : Integer -> int 변환(언박싱)
        */
    }
}