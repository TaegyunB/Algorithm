import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int x = -1;
        int y = 0;
        int num = 1;
        
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (i % 3 == 0) {  // 아래
                    x++;
                } else if (i % 3 == 1) {  // 오른쪽
                    y++;
                } else if (i % 3 == 2) {  // 대각선
                    x--;
                    y--;
                }
                
                arr[x][y] = num;
                num++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                
                list.add(arr[i][j]);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}