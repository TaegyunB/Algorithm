import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        
        int cnt = 0;
        while (!pq.isEmpty()) {
            int a = pq.poll();
            
            // pq의 첫번째 값이 K보다 크다는 뜻은
            // 모든 음식의 스코빌 지수를 K 이상으로 만들었다는 뜻
            if (a >= K) {
               return cnt;
            }
            
            // 계속 돌면서 pq 사이즈가 1 미만이라는 것은
            // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우라는 뜻
            if (pq.size() < 1) {
                return -1;
            }
            
            int b = pq.poll();
            
            int newScoville = a + (b * 2);
            
            pq.offer(newScoville);
            cnt++;
        }
        
        return cnt;
    }
}