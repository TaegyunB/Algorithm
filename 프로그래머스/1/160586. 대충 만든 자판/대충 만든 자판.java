    import java.util.*;

    class Solution {
        public int[] solution(String[] keymap, String[] targets) {

            Map<Character, Integer> map = new HashMap<>();

            for(int i=0; i<keymap.length; i++) {
                for(int j=0; j<keymap[i].length(); j++) {
                    char currentChar = keymap[i].charAt(j);
                    int times = j + 1;
                    
                    if(map.containsKey(currentChar)) {  // key 값이 있으면
                        map.put(currentChar, Math.min(map.get(currentChar), times));
                    } else {
                        map.put(currentChar, times);
                    }
                }
            }
            
            ArrayList<Integer> answer = new ArrayList<>();

            for(int i=0; i<targets.length; i++) {
                int sum = 0;
                boolean canMake = true;
                
                for(int j=0; j<targets[i].length(); j++) {
                    char ch = targets[i].charAt(j);
                    Integer value = map.get(ch);
                    if(value == null) {  // 목표 문자열을 작성할 수 없을 때
                        canMake = false;
                        break;
                    }  // 목표 문자열을 만들 수 있을 때
                    sum += value;
                }

                if(canMake) {
                    answer.add(sum);
                } else {
                    answer.add(-1);
                }
            }
            
            return answer.stream().mapToInt(i -> i).toArray();
        }
    }