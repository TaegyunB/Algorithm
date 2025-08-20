import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        Map<Character, Integer> alp = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            if (alp.containsKey(s.charAt(i))) {
                answer.add(i - alp.get(s.charAt(i)));
            } else {
                answer.add(-1);
            }
            alp.put(s.charAt(i), i);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}