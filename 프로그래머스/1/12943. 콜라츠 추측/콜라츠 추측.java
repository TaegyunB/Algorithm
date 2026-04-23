class Solution {
    public int solution(int num) {
        // 내가 실수한 것
        // int num으로 사용해서 오버플로우 발생 -> long으로 해야함
        
        int cnt = 0;
        long n = num;
        
        if (n == 1) {
            return 0;
        }
        
        while (n != 1) {
            if (cnt >= 500) {
                return -1;
            }
            
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n *= 3;
                n += 1;
            }
            
            cnt++;
        }
        
        return cnt;
    }
}