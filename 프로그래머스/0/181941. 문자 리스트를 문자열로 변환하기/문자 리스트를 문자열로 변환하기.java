class Solution {
    public String solution(String[] arr) {
        String answer = "";
        int len = arr.length; // length O, length() X
        
        for(int i=0; i<len; i++){
            answer += arr[i]; // 배열이니깐 [] 사용 가능
        }
        
        return answer;
    }
}