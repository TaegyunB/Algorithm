import java.util.*;

class Solution {
    
    static Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
    
    public int solution(String s) {
        int answer = 0;
        
        // 문자열 회전을 위해 StringBuilder를 사용
        StringBuilder sb = new StringBuilder(s);
        
        for (int i=0; i<s.length(); i++) {
            
            // 현재 회전 상태가 올바른 괄호 문자열이면 카운트
            if (isValid(sb)) {
                answer++;
            }
            
            // 맨 앞 문자를 떼서 맨 뒤에 붙임
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);
        }
        
        return answer;
    }
    
    // 주어진 문자열이 올바른 괄호 문자열인지 검사
    private static boolean isValid(StringBuilder sb) {
        
        Deque<Character> stack = new ArrayDeque<>();  // 여는 괄호를 임시 저장할 스택
        
        for (int i=0; i<sb.length(); i++) {
            char cur = sb.charAt(i);
            
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else {
                // 스택이 비어있으면 짝이 될 여는 괄호가 없고 pop한 괄호가 닫는 괄호와 짝이 맞지 않으면 실패
                if (stack.isEmpty() || stack.pop() != map.get(cur))  {
                    return false;
                }
            }
        }
        
        // 반복문을 끝까지 통과했어도 스택에 여는 괄호가 남아있으면 안되니깐 isEmpty() 구분
        return stack.isEmpty();
    }
}