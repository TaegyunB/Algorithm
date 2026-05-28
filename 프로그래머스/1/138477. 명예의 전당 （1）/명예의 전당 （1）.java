import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 우선순위 큐
        List<Integer> answer = new ArrayList<>();  // 정답 리스트
        
        for (int i=0; i<score.length; i++) {
            pq.offer(score[i]);  // pq에 추가
            
            if (pq.size() > k) {  // pq 사이즈가 k보다 크다면 제일 낮은 점수 하나 빼야함
                pq.poll();
            }
            
            answer.add(pq.peek());  // 제일 낮은 점수를 answer에 추가
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}