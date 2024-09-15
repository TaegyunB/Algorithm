import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<intStrs.length; i++){
            String cut = intStrs[i].substring(s, s+l);
            int cut_int = Integer.parseInt(cut);
            
            if(cut_int > k){
                answer.add(cut_int);
            }
        }
        
        return answer.stream().mapToInt(num -> num).toArray();
    }
}