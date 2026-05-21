class Solution {
    public int solution(String s) {
        int top = 0;  // 스택의 맨 위 위치 (다음에 쌓일 인덱스)
        char[] stack = new char[s.length()];  // char 배열을 스택으로 사용
        
        for (int i=0; i<s.length(); i++) {
            // 스택이 비어있지 않고 맨 위 문자가 현재 문자와 같으면 짝을 발견한거니깐
            if (top > 0 && stack[top-1] == s.charAt(i)) {
                top--;  // pop
            } else {  // 스택이 비어있고 맨 위 문자가 현재 문자와 다르다면 짝을 발견하지 못한거니깐
                stack[top] = s.charAt(i);  // push -> 문자 쌓기
                top++;
            }
        }
        
        if (top == 0) {  // 스택이 비어있다는 의미
            return 1;
        } else {
            return 0;
        }
        
        
        
    }
}