import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[numbers.length];  // 인덱스 값을 저장
        
        Arrays.fill(answer, -1);
        
        for (int i=0; i<numbers.length; i++) {
            // 스택이 비어있지 않고, 현재 숫자가 '스택 맨 위 인덱스'의 숫자보다 크다면
            while (!stack.isEmpty() && numbers[stack.peekLast()] < numbers[i]) {
                // 해당 인덱스의 정답을 현재 숫자로 기록하고 스택에서 제거
                int idx = stack.pollLast();
                answer[idx] = numbers[i];
            }
            
            // 값이 아닌 '인덱스'를 스택에 추가
            stack.offerLast(i);
        }
        
        return answer;
     }
}