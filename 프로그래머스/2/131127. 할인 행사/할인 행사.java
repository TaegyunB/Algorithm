import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        
        for (int i=0; i<=discount.length-10; i++) {
            Map<String, Integer> map = new HashMap<>();
            
            for (int j=0; j<want.length; j++) {
                map.put(want[j], number[j]);
            }
            
            for (int j=i; j<i+10; j++) {
                if (map.containsKey(discount[j])) {
                    map.put(discount[j], map.get(discount[j]) - 1);
                }
            }
            
            // System.out.println(map);
            
            boolean finish = true;
            for (int cnt : map.values()) {
                if (cnt != 0) {
                    finish = false;
                }
            }
            
            if (!finish) {
                continue;
            }
            
            answer++;
        }
        
        return answer;
    }
}