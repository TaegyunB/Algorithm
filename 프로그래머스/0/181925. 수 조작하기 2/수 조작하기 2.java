class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        int num = numLog[0];
        
        for(int i=1; i<numLog.length; i++){
            int sub = numLog[i] - numLog[i-1];
            if(sub == 1){
                answer += "w";
            }
            else if(sub == -1){
                answer += "s";
            }
            else if(sub == 10){
                answer += "d";
            }
            else if(sub == -10){
                answer += "a";
            }
        }
        
        return answer;
    }
}