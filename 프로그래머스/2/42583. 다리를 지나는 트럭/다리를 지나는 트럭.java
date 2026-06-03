import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(truck_weights[0]);
        
        int sum = truck_weights[0];
        int i = 1;
        int cnt = 1;
        
        while (!q.isEmpty()) {
            if (i >= truck_weights.length) {
                cnt += bridge_length;
                break;
            } 
            
            if (q.size() >= bridge_length) {
                sum -= q.poll();
            }
            
            if (q.size() < bridge_length) {
                if (sum + truck_weights[i] <= weight) {
                    q.offer(truck_weights[i]);
                    sum += truck_weights[i];
                    i++;
                } else {
                    q.offer(0);
                }
            }
            
            cnt++;
        }
        
        return cnt;
    }
}