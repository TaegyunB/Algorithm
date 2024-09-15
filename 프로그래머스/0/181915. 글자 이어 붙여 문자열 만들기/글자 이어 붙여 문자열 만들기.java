class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        
        for(int i=0; i<index_list.length; i++){
            int index = index_list[i];
            char ch = my_string.charAt(index);
            answer += ch;
        }
        
        return answer;
    }
}