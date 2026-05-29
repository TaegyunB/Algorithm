import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // stack을 활용하는데 stack에 값을 넣는게 아니라 인덱스 값을 넣는 것
        int n = prices.length;
        int[] answer = new int[n];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i=0; i<prices.length; i++) {
            
            // 스택이 비어있지 않거나 stack.peek() 값의 주식 가격이 현재 주식 가격보다 크다면 떨어졌다는 뜻이기 때문에
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();  // pop
                answer[idx] = i - idx;  // pop한 값의 answer 배열에 현재 인덱스 값에서 pop한 값을 뺀 값을 추가
            }
            
            stack.push(i);  // 그 외에는 그냥 push
        }
        
        // stack에서 idx 값을 꺼내서 각각 가격이 떨어지지 않은 기간 구하기
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - idx - 1;
        }
        
        return answer;
    }
}