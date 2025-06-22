import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] letters = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            letters[i] = s.charAt(i);
        }
        
        Stack<Character> stack = new Stack<>();  // 스택 선언
        
        for(int i=0; i<letters.length; i++) {
            if(letters[0] == ')') {
                answer = false;
                break;
            }
            
            if(letters[i] == '(') {
                stack.push(letters[i]);
            } else {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}