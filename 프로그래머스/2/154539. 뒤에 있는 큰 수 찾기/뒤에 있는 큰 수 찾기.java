import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[numbers.length];
        
        Arrays.fill(answer, -1);
        
        for (int i=0; i<numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peekLast()] < numbers[i]) {
                int idx = stack.pollLast();
                answer[idx] = numbers[i];
            }
            
            stack.offerLast(i);
        }
        
        return answer;
     }
}