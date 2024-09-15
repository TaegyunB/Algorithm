import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        
        ArrayList<Integer> lists = new ArrayList<>();
        
        for(int i=start_num; i<=end_num; i++){
            lists.add(i);
        }
        return lists.stream().mapToInt(i -> i).toArray();
    }
}