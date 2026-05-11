class Solution {
    public int solution(int[] wallet, int[] bill) {
        int cnt = 0;
        
        boolean flag = true;
        int bigIdx = 0;
        
        while (flag) {
            // 접기 전에 먼저 지갑에 들어가는지 체크 (그대로 or 90도 회전)
            if (wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
                break;
            } else if (wallet[0] >= bill[1] && wallet[1] >= bill[0]) {
                break;
            }
            
            // 긴 쪽 인덱스 설정
            if (bill[0] > bill[1]) {
                bigIdx = 0;
            } else if (bill[0] < bill[1]) {
                bigIdx = 1;
            }
            
            bill[bigIdx] /= 2;  // 긴 쪽 반으로 접기
            cnt++;
            
            // 접은 후 다시 체크 (그대로 or 90도 회전)
            if (wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
                break;
            } else if (wallet[0] >= bill[1] && wallet[1] >= bill[0]) {
                break;
            }
        }
        
        return cnt;
    }
}