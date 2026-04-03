class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int area = brown + yellow;
        
        for (int h = 3; h * h <= area; h++) {  // h * h: 절반 탐색 및 중복 탐색 방지
            // h * w == area를 구하기 위해 (h, w)쌍을 구하기
            if (area % h == 0) {
                int w = area / h;
                
                // W >= H >= 3
                if ((2 * h) + (2 * w) - 4 == brown) {
                    return new int[]{w, h};
                }
            }
        }
        
        return new int[]{};
    }
}