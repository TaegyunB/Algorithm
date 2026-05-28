import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);  // 먼저 정렬을 한 후
        
        // 투 포인터로 풀 것이기 때문에 left, right 지정
        int left = 0;
        int right = people.length - 1;
        
        int cnt = 0;  // 보트의 수
        
        while (left <= right) {  // left가 right보다 크지 않을 때 까지
            int sum = people[left] + people[right];  // 두 사람의 몸무게를 더한 값
            
            if (sum <= limit) {  // 합이 limit보다 작으면 두 사람을 모두 태울 수 있으니깐
                left++;  // 다음 사람으로
                right--;  // 다음 사람으로
            } else {  // 합이 limit보다 크다는 것은 한 사람만 태울 수 있다는 뜻이니깐
                right--;  // 큰 값을 먼저 다음으로
            }
            
            cnt++;  // 보트 수 추가
        }
        
        return cnt;
    }
}