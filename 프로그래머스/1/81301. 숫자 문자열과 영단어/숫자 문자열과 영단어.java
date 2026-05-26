import java.util.*;

class Solution {
    
    static Map<String, String> map = Map.of(
        "zero", "0",
        "one", "1",
        "two", "2",
        "three", "3",
        "four", "4",
        "five", "5",
        "six", "6",
        "seven", "7",
        "eight", "8",
        "nine", "9"
    );
    
    public int solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) - '0' <= 9) {
                answer.append(s.charAt(i));
                continue;
            }
            
            sb.append(s.charAt(i));
            
            if (map.containsKey(sb.toString())) {
                answer.append(map.get(sb.toString()));
                sb = new StringBuilder();   
            }
        }
        
        System.out.println(answer.toString());
        
        return Integer.parseInt(answer.toString());
    }
}