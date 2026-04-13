import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] remains = new int[progresses.length];
        
        for (int i=0; i<progresses.length; i++) {
            remains[i] = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        
        int start = remains[0];
        int cnt = 1;
        for (int i=1; i<=remains.length; i++) {
            
            if (i == remains.length) {
                list.add(cnt);
                break;
            }
            
            if (start >= remains[i]) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                start = remains[i];
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}