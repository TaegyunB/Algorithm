class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<my_strings.length; i++){
            StringBuilder sb = new StringBuilder(my_strings[i]);
            int start = parts[i][0];
            int end = parts[i][1];
            
            StringBuilder cut = new StringBuilder(sb.substring(start, end+1));
            answer.append(cut);
        }
        
        return answer.toString();
    }
}