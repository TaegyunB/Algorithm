class Solution {
    public int[] solution(String[] wallpaper) {
        int min_x = 50;
        int max_x = 0;
        int min_y = 50;
        int max_y = 0;

        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                // 파일 발견했을 때
                if(wallpaper[i].charAt(j) == '#') {
                    if(i < min_x) {
                        min_x = i;
                    }
                    if(max_x < i) {
                        max_x = i;
                    }
                    if(j < min_y) {
                        min_y = j;
                    }
                    if(max_y < j) {
                        max_y = j;
                    }
                }
            }
        }
        
        int[] answer = {min_x, min_y, max_x+1, max_y+1};
        return answer;
    }
}