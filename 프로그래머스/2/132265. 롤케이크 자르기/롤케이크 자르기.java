import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> chul = new HashSet<>();
        Map<Integer, Integer> brother = new HashMap<>();
        
        // brother에 우선 다 담기
        for (int i=0; i<topping.length; i++) {
            brother.put(topping[i], brother.getOrDefault(topping[i], 0) + 1);
        }
        
        // brother에서 chul에 하나씩 넘기기
        for (int i=0; i<topping.length; i++) {            
            int cur = topping[i];
            
            chul.add(cur);
            brother.put(cur, brother.get(cur) - 1);
            
            if (brother.get(cur) == 0) {
                brother.remove(cur);
            }
            
            if (chul.size() == brother.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}