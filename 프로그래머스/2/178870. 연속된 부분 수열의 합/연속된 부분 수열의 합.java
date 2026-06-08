class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        
        int left = 0;
        int right = 0;
        
        int len = n;
        int minIdx = 0;
        int maxIdx = 0;
        int sum = sequence[0];
        
        while (left <= right) {
            if (sum < k) {
                if (right >= n-1) {
                    break;
                }
                right++;
                sum += sequence[right];
            } else if (sum > k) {
                sum -= sequence[left];
                left++;
            } else if (sum == k) {
                if (right - left < len) {
                    len = right - left;
                    minIdx = left;
                    maxIdx = right;
                }
                right++;
                
                if (right >= n) {
                    break;
                }
                
                sum += sequence[right];
            }
        }
        
        return new int[]{minIdx, maxIdx};
    }
}