import java.util.*;

public class Solution {
    public int solution(int n) {
        String sn = String.valueOf(n);
        int answer = 0;
        
        for (int i=0; i<sn.length(); i++) {
            answer += sn.charAt(i) - '0';
        }
        
        return answer;
    }
}