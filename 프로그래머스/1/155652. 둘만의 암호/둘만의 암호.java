class Solution {
    public String solution(String s, String skip, int index) {
        
        StringBuilder sb = new StringBuilder();  // 가변(mutable) 문자열을 효율적으로 다루기 위한 클래스
        
        for(char ch : s.toCharArray()) {
            int cnt = 0;
            
            while(cnt < index) {
                if(ch == 'z') {
                    ch = 'a';
                } else {
                    ch++;  // ASCII 값을 1 증가시켜서 다음 알파벳 문자로 변환
                }
                
                if(!skip.contains(String.valueOf(ch))) {  // char 타입 변수를 String으로 변환
                   cnt++; 
                }
            }
            
            sb.append(ch);
        }
        
        return sb.toString();
    }
}