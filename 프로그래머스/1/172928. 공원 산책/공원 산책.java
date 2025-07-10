class Solution {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int[] solution(String[] park, String[] routes) {

        int[] startPos = findStart(park);
        int x = startPos[0];
        int y = startPos[1];
        int H = park.length;
        int W = park[0].length();
        
        for(int i=0; i<routes.length; i++) {
            int times = routes[i].charAt(2) - '0';
            
            int nx = x;
            int ny = y;
            int dir = 0;
            boolean canMove = true;
            
            // 이동 경로를 한 칸씩 확인
            for(int j=0; j<times; j++) {
                if(routes[i].charAt(0) == 'E') {
                    dir = 0;
                } else if(routes[i].charAt(0) == 'S') {
                    dir = 1;
                } else if(routes[i].charAt(0) == 'W') {
                    dir = 2;
                } else if(routes[i].charAt(0) == 'N') {
                    dir = 3;
                }
                
                nx += dx[dir];
                ny += dy[dir];
                
                if(nx < 0 || nx >= H || ny < 0 || ny >= W || park[nx].charAt(ny) == 'X') {
                    canMove = false;
                    break;
                }
            }
            
            if(canMove) {            
                x = nx;
                y = ny;
            }
        }
        
        return new int[]{x, y};
    }
    
    public int[] findStart(String[] park) {
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}