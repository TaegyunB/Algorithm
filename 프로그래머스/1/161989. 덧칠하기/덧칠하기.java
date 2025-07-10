class Solution {
    public int solution(int n, int m, int[] section) {
        
        int start = section[0];
        int result = 1;
        
        for(int i=1; i<section.length; i++) {
            
            if(start + m > section[i]) {
                continue;
            }
            start = section[i];
            result++;
        }
        
        return result;
    }
}