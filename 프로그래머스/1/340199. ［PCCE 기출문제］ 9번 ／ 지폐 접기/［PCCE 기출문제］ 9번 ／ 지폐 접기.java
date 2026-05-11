class Solution {
    public int solution(int[] wallet, int[] bill) {
        int cnt = 0;
        
        boolean flag = true;
        int bigIdx = 0;
        
        while (flag) {
            if (wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
                break;
            } else if (wallet[0] >= bill[1] && wallet[1] >= bill[0]) {
                break;
            }
            
            if (bill[0] > bill[1]) {
                bigIdx = 0;
            } else if (bill[0] < bill[1]) {
                bigIdx = 1;
            }
            
            bill[bigIdx] /= 2;
            cnt++;
            
            if (wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
                break;
            } else if (wallet[0] >= bill[1] && wallet[1] >= bill[0]) {
                break;
            }
        }
        
        return cnt;
    }
}