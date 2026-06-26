import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=1; i<=n; i++) {
            q.offerLast(i);
        }
        
        int round = 0;
        boolean flag = false;
        
        while (!flag) {
            for (int i=1; i<=n/2; i++) {
                int p1 = q.pollFirst();
                int p2 = q.pollFirst();
                
                if (p1 == a && p2 == b) {
                    round++;
                    return round;
                }
                
                if (p1 != a && p2 != a && p1 != b && p2 != b) {
                    q.offerLast(p1);
                }
                
                if (p1 == a || p2 == a) {
                    q.offerLast(a);
                } else if (p1 == b || p2 == b) {
                    q.offerLast(b);
                } 
            }
            
            round++;
            n /= 2;
        }
        
        return round;
    }
}