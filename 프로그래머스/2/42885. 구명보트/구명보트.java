import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 실수 - 최대 2명씩 밖에 탈 수 없다는 것을 까먹고 있었음
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        int cnt = 0;
        
        while (left <= right) {
            int sum = people[left] + people[right];
            
            if (sum <= limit) {
                left++;
                right--;
                cnt++;
            } else {
                right--;
                cnt++;
            }
        }
        
        return cnt;
    }
}