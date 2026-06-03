import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i=0; i<scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int cnt = 0;
        
        while (!pq.isEmpty()) {
            if (pq.peek() >= K) {
                return cnt;
            }
            
            if (pq.size() <= 1) {
                return -1;
            }
            
            int firstMin = pq.poll();
            int secondMin = pq.poll();
            
            int newSco = firstMin + (secondMin * 2);
            pq.offer(newSco);
            cnt++;
        }
        
        return -1;
    }
}