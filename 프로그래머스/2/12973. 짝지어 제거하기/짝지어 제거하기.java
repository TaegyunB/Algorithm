import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();  // 스택
        
        for (char c : s.toCharArray()) {  // char 배열로 변환해서 순회
            if (!stack.isEmpty() && stack.peek() == c) {  // stack이 비어 있지 않고 stack 마지막 요소가 c와 같다는 것은 같은 알파벳 2개가 붙어 있다는 뜻
                stack.pop();  // pop
            } else {  // stack이 비어 있고 stack 마지막 요소가 c와 같지 않다는 것은 같은 알파벳이 아니라는 뜻
                stack.push(c);  // push
            }
        }
        
        if (stack.isEmpty()) {  // stack이 비어있다는 것은 다 제거했다는 것
            return 1;  // 1 리턴 
        } else {  // stack이 비어있지 않다는 것은 다 제거하지 못했다는 것
            return 0;  // 0 리턴
        }
    }
}