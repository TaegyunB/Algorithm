import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int p_length = p.length();
        int result = 0;
        
        for(int i=0; i<=t.length() - p_length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for(int j=i; j<i + p_length; j++) {
                sb.append(t.charAt(j));
            }
            
//             System.out.println(sb.toString());
            
            if (Long.parseLong(sb.toString()) <= Long.parseLong(p)) {
                result++;
            }
        }
        
        return result;
    }
}