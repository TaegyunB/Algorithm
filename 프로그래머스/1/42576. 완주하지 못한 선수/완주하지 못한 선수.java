import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);  // 정렬
        Arrays.sort(completion);  // 정렬
                
        int i=0;
        for (i=0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                break;
            }
        }
        
        return participant[i];
    }
}