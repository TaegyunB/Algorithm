class Solution {
    public int solution(String number) {
        int add = 0;
        
        for(int i=0; i<number.length(); i++){
            char ch = number.charAt(i);
            int ch_int = Integer.parseInt(String.valueOf(ch));
            // int ch_int = ch - '0'; ASCII 코드 활용
            add += ch_int;
        }
        
        int answer = add % 9;
        return answer;
    }
}