import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        int target = 0;
        int currentEnd = -1;
        
        for(int[] t : targets) {
            
            if (currentEnd == -1) {
                target++;
                currentEnd = t[1];
                continue;
            };
            
            if(t[0] < currentEnd) {
                continue;
            }
            
            target++;
            currentEnd = t[1];
        }
        
        return target;
    }
}
