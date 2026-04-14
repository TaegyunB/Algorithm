import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                list.add(-1);
            } else {
                int idx = map.get(s.charAt(i));
                list.add(i - idx);
                map.put(s.charAt(i), i);
            }
        }
        
        return list.stream().mapToInt(x -> x).toArray();
    }
}