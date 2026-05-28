import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i=0; i<score.length; i++) {
            pq.offer(score[i]);
            
            if (pq.size() > k) {
                pq.poll();
            }
            
            answer.add(pq.peek());
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}