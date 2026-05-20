class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxHeight = 0;
        int maxWidth = 0;
        
        for (int i=0; i<sizes.length; i++) {
            int width = sizes[i][0];
            int height = sizes[i][1];
            int temp = 0;
            
            if (height > width) {
                temp = width;
                sizes[i][0] = height;
                sizes[i][1] = temp;
            }
            
            if (sizes[i][0] > maxHeight) {
                maxHeight = sizes[i][0];
            }
            
            if (sizes[i][1] > maxWidth) {
                maxWidth = sizes[i][1];
            }
        }
        
        return maxHeight * maxWidth;
    }
}