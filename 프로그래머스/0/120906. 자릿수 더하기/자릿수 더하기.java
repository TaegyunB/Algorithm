class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String input = String.valueOf(n);
        for (int i=0; i<input.length(); i++) {
            int num = input.charAt(i) - '0';
            answer += num;
        }
        
        return answer;
    }
}