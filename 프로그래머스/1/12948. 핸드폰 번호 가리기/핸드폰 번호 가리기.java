class Solution {
    public String solution(String phone_number) {
        // 내가 실수한 것
        // python문법을 java에서 썼음
        // '*' * phone_number.length() - 4;
        // 이런 문법은 없음
        
        char[] arr = phone_number.toCharArray();
        
        for (int i=0; i<arr.length-4; i++) {
            arr[i] = '*';
        }
        
        return new String(arr);
    }
}