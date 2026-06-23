import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int[] total = new int[map.size()];
        
        int idx = 0;
        for (int num : map.keySet()) {
            total[idx] = map.get(num);
            idx++;
        }
        
        Arrays.sort(total);
        
        int cnt = 0;
        int sum = 0;
        for (int i=total.length-1; i>=0; i--) {
            sum += total[i];
            cnt++;
            
            if (cnt == 0  && sum > k) {
                return 1;
            }
            
            if (sum >= k) {
                return cnt;
            }
        }
        
        return 0;
    }
}