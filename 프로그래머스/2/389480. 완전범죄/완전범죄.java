import java.util.*;

class Solution {
    static int[][] infoa;
    static int na;
    static int ma;
    static int answer;
    static Set<Pos> posSet;
    
    static class Pos {
        int a, b, index;
        
        Pos (int a, int b, int index) {
            this.a = a;
            this.b = b;
            this.index = index;
        }
        
        public boolean equals(Object obj) {
            Pos o = (Pos) obj;
            
            if (this.a == o.a && this.b == o.b && this.index == o.index) {
                return true;
            }
            return false;
        }
        
        public int hashCode() {
            int result = 1;
            result = 31 * result + a;
            result = 31 * result + b;
            result = 31 * result + index;
            
            return result;
        }
        
    }
    
    static void bf(int a, int b, int index) {
        Pos pos = new Pos(a, b, index);
        
        if (posSet.contains(pos)) {
            return;
        }
        
        posSet.add(new Pos(a, b, index));
        
        if (index == infoa.length) {
            if (b < ma && a < na && a < answer) {
                answer = a;
            }
            
            return;
        }
        
        bf(a + infoa[index][0], b, index + 1);  // info[index] 를 a가 가져가는 경우
        bf(a, b + infoa[index][1], index + 1);  // info[index] 를 b가 가져가는 경우
    }
    
    public int solution(int[][] info, int n, int m) {
        infoa = info;
        na = n;
        ma = m;
        answer = Integer.MAX_VALUE;
        
        posSet = new HashSet<>();
        
        bf(0, 0, 0);
        
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        return answer;
    }
}