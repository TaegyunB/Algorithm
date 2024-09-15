import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=l; i<=r; i++){
            String i_str = Integer.toString(i);
            boolean valid = true;
            
            for(int j=0; j<i_str.length(); j++){
                char ch = i_str.charAt(j);
                if(ch != '5' && ch != '0'){ // "0"과 "5" 외의 숫자가 있는지 확인
                    valid = false;
                    break;
                } 
            }
            if(valid == true){
                answer.add(i);
            }
        }
        
        // 조건을 만족하는 숫자가 없으면 -1을 반환
        if(answer.isEmpty()){
            return new int[]{-1};
        }
        else{
            return answer.stream().mapToInt(i -> i).toArray();
        }
        
    }
}