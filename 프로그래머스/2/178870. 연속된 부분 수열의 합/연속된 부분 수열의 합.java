class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        
        int len = Integer.MAX_VALUE;
        int left = 0;  // 윈도우의 왼쪽 끝
        int sum = 0;
        
        int minIdx = 0;
        int maxIdx = 0;
        
        // 윈도우의 오른쪽 끝
        for (int right = 0; right < n; right++) {
            sum += sequence[right];  // 오른쪽 원소를 윈도우에 추가
            
            // 합이 k를 넘으면 왼쪽 원소를 빼면서 left를 당겨 합을 줄임
            while (sum > k) {
                sum -= sequence[left];
                left++;
            }
            
            if (sum == k) {
                if (right - left < len) {
                    len = right - left;
                    minIdx = left;
                    maxIdx = right;
                }
            }
        } 
        
        return new int[]{minIdx, maxIdx};
    }
}