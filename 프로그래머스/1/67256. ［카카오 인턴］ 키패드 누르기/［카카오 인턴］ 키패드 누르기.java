class Solution {
    static int[][] phone = {
        {3, 1},  // 0
        {0, 0},  // 1
        {0, 1},  // 2
        {0, 2},  // 3
        {1, 0},  // 4
        {1, 1},  // 5
        {1, 2},  // 6
        {2, 0},  // 7
        {2, 1},  // 8
        {2, 2},  // 9
        {3, 0},  // *
        {3, 2}  // #
    };
    
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        
        int[] left = phone[10];  // 왼손 시작
        int[] right = phone[11];  // 오른손 시작
        
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {  // 왼손 고정
                sb.append("L");
                left = phone[num];
            } else if (num == 3 || num == 6 || num == 9) {  // 오른손 고정
                sb.append("R");
                right = phone[num];
            } else {  // 중간 2, 5, 8, 0
                int[] target = phone[num];
                
                int ldist = Math.abs(target[0] - left[0]) + Math.abs(target[1] - left[1]);
                int rdist = Math.abs(target[0] - right[0]) + Math.abs(target[1] - right[1]);
                
                if (ldist < rdist) {
                    sb.append("L");
                    left = phone[num];
                } else if (ldist > rdist) {
                    sb.append("R");
                    right = phone[num];
                } else if (ldist == rdist) {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = phone[num];
                    } else if (hand.equals("right")) {
                        sb.append("R");
                        right = phone[num];
                    }
                }
            } 
        }
        
        return sb.toString();
    }
}