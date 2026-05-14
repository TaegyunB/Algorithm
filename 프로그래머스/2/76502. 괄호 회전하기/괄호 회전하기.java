import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(s);
        
        for (int i=0; i<s.length(); i++) {
            
            Deque<Character> stack = new ArrayDeque<>();
            int flag = 0;
            
            for (int j=0; j<s.length(); j++) {
                if (sb.charAt(j) == '[' || sb.charAt(j) == '(' || sb.charAt(j) == '{') {
                    stack.offerLast(sb.charAt(j));
                    flag++;
                } else {
                    flag--;
                    if (stack.isEmpty()) {
                        continue;
                    }
                    
                    if (stack.peekLast() == '[') {
                        if (sb.charAt(j) == ']') {
                            stack.pollLast();
                        }
                    }
                    else if (stack.peekLast() == '(') {
                        if (sb.charAt(j) == ')') {
                            stack.pollLast();
                        } 
                    }
                    else if (stack.peekLast() == '{') {
                        if (sb.charAt(j) == '}') {
                            stack.pollLast();   
                        }
                    }
                }
            }
            
            if (flag != 0) {
                return answer;
            }
            
            String first = sb.substring(0, 1);
            String remain = sb.substring(1, s.length());
            
            sb = new StringBuilder(remain);
            sb.append(first);
            
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}