import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(truck_weights[0]);  // 첫번째 트럭을 다리에 올림
        
        int sum = truck_weights[0];  // 현재 다리 위 트럭들의 무게 합
        int i = 1;  // 다음에 올라갈 트럭 인덱스
        int cnt = 1;  // 경과 시간
        
        while (!q.isEmpty()) {
            // 모든 트럭이 다리에 올랐으면, 마지막 트럭이 다 건너는 시간만 더하고 종료
            if (i >= truck_weights.length) {
                cnt += bridge_length;
                break;
            }
            
            // 다리가 꽉 찼으면 맨 앞 트럭을 내려 한 칸 공간 확보
            if (q.size() >= bridge_length) {
                sum -= q.poll();
            }
            
            // 빈 자리가 생겼으니 다음 트럭을 올리거나 빈 자리(0)을 채움
            if (q.size() < bridge_length) {
                if (sum + truck_weights[i] <= weight) {
                    sum += truck_weights[i];
                    q.offer(truck_weights[i]);  // 다음 트럭 올림
                    i++;
                } else {
                    q.offer(0);  // 무게 초과 -> 빈 자리로 채움
                }
            }
            
            cnt++;  // 1초 경과
        }
        
        return cnt;
    }
}