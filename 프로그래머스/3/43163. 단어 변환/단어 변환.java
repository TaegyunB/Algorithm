import java.util.*;

class Solution {
    
    // 큐에 저장할 위치 정보 클래스 (단어와 변환 단계 수)
    static class Pos {
        String current;
        int dist;

        Pos(String current, int dist) {
            this.current = current;
            this.dist = dist;
        }
    }
    
    // 메인 함수
    public int solution(String begin, String target, String[] words) {
        
        // target 단어가 words 배열에 있는지 확인
        boolean hasTarget = false;
        for (String word : words) {
            if (target.equals(word)) {
                hasTarget = true;
                break;
            }
        }
        
        if (!hasTarget) {
            return 0;
        }
        
        boolean[] visited = new boolean[words.length];
        return bfs(begin, target, words, visited); 
    }
    
    // BFS를 이용한 최단 경로 탐색
    private int bfs(String begin, String target, String[] words, boolean[] visited) {
        // BFS를 위한 큐 생성
        Queue<Pos> q = new LinkedList<>();
        
        // 시작 단어를 큐에 추가 (변환 단계 0부터 시작)
        q.offer(new Pos(begin, 0));
        
        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            String current = pos.current;
            int dist = pos.dist;
            
            // 목표 단어에 도달했는지 확인
            if (current.equals(target)) {
                return dist;
            }
            
            for (int i=0; i<words.length; i++) {
                String word = words[i];
                boolean isChecked = check(current, word);
                
                // 변환 가능하고 아직 방문하지 않은 단어라면
                if (isChecked && !visited[i]) {
                    q.offer(new Pos(word, dist+1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    // 두 단어가 정확히 한 글자만 다른지 확인하는 함수
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