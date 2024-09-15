import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> lists = new ArrayList<>();
        
        for(int i=0; i<my_string.length(); i++){
            String cut = my_string.substring(i, my_string.length());
            lists.add(cut);
        }
        
        Collections.sort(lists); // 사전순으로 정렬
        
        return lists.toArray(new String[0]);
    }
}