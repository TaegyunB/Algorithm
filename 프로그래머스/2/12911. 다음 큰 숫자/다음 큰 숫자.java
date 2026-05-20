class Solution {
    public int solution(int n) {
        // Integer.bitCount() : n을 2진수로 변환했을 때 1의 개수를 반환
        
        int standardOne = Integer.bitCount(n);
        n++;
        
        while (Integer.bitCount(n) != standardOne) {
            n++;
            
        }
        
        return n;
    }
}