class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        
        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            
            StringBuilder reverse = new StringBuilder(sb.substring(start, end+1));
            reverse.reverse();
            
            sb.replace(start, end+1, reverse.toString()); // String으로 변경
            
        }
        return sb.toString(); // String으로 변경
    }
}