import java.util.*;

class Solution {
    public long solution(long n) {
        String sn = String.valueOf(n);
        int[] arr = new int[sn.length()];
        
        for (int i=0; i<sn.length(); i++) {
            arr[i] = sn.charAt(i) - '0';
        }
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for (int i=sn.length()-1; i>=0; i--) {
            sb.append(arr[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}