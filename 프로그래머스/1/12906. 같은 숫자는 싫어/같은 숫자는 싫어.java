import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 스택 선언
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<arr.length; i++) {
            if (stack.isEmpty()) {
                stack.add(arr[i]);
            } else if(stack.peek() != arr[i]) {
                stack.add(arr[i]);
            }
        }
        
        return stack.stream().mapToInt(i -> i).toArray();
    }
}