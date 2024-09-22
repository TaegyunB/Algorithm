import java.util.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        
        int n = my_string.length();
        String[] suffix = new String[n];
        
        for(int i=0; i<n; i++){
            suffix[i] = my_string.substring(i);
        }
        
        for(String s : suffix){
            if(s.equals(is_suffix)){
                return 1;
            }
        }  
        
        return 0;
        
        
    }
}