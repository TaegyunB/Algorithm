import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        
        if (arr.length == 1) {
            return new int[]{-1};
        }
        
        int min = arr[0];
        int idx = 0;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                idx = i;
            }
        }
        
        for (int i=0; i<arr.length; i++) {
            if (idx == i) {
                continue;
            }
            
            answer.add(arr[i]);
        }
        
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}