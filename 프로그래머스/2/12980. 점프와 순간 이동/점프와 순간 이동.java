import java.util.*;

public class Solution {
    public int solution(int n) {
        int cnt = 0;
        
        while (n != 0) {
            int m = n / 2;
            int remain = n % 2;
            
            if (remain == 1) {
                cnt++;
            }
            
            n = m;
        }
        
        return cnt;
    }
}