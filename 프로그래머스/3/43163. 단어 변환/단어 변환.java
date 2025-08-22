import java.util.*;

class Solution {
    
    static class Pos {
        String current;
        int dist;

        Pos(String current, int dist) {
            this.current = current;
            this.dist = dist;
        }
    }
    
    // main 
    public int solution(String begin, String target, String[] words) {
        
        // begin 단어가 words에 없으면 return 0
        boolean hasTarget = false;
        for (String word : words) {
            if (target.equals(word)) {
                hasTarget = true;
            }
        }
        
        if (!hasTarget) {
            return 0;
        }
        
        boolean[] visited = new boolean[words.length];
        return bfs(begin, target, words, visited); 
    }
    
    // bfs
    private int bfs(String begin, String target, String[] words, boolean[] visited) {
        Queue<Pos> q = new LinkedList<>();
        
        q.offer(new Pos(begin, 0));
        
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            String current = pos.current;
            int dist = pos.dist;
            
            // 변환해서 같아졌으면
            if (current.equals(target)) {
                return dist;
            }
            
            for (int i=0; i<words.length; i++) {
                String word = words[i];
                boolean isChecked = check(current, word);
                
                if (isChecked && !visited[i]) {
                    q.offer(new Pos(word, dist+1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    // 한글자 이상 다른지 확인
    private boolean check(String word_1, String word_2) {
            
        int cnt_diff = 0;
        for (int i=0; i<word_1.length(); i++) {
            if (word_1.charAt(i) != word_2.charAt(i)) {
                cnt_diff++;
            }
        }

        if (cnt_diff == 1) {
            return true;
        } else {
            return false;
        }
    }
}