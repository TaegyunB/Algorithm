import java.util.*;

class Solution {
    public String solution(String s) {

        char[] c = s.toCharArray();
        Arrays.sort(c);
        
        char[] answer = new char[c.length];
        int idx = 0;
        for (int i=c.length-1; i>=0; i--) {
            answer[idx] = c[i];
            idx++;
        }
        
        return new String(answer);
    }
}