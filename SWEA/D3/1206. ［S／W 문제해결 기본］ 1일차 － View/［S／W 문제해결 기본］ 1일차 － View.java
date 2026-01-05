import java.util.*;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for (int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			int[] buildings = new int[N];
			
            // 건물 층 입력
			for (int i=0; i<N; i++) {
				buildings[i] = sc.nextInt();
			}
		
			int sum = 0;
			for (int i=2; i<N-2; i++) {
				int cur = buildings[i];  // 현재 건물
				int left1 = buildings[i-2];  // 왼쪽 두번째 건물
				int left2 = buildings[i-1];  // 왼쪽 첫번째 건물
				int right1 = buildings[i+1];  // 오른쪽 첫번째 건물
				int right2 = buildings[i+2];  // 오른쪽 두번째 건물
				
				// 위 4중에서 가장 큰 값 찾기
				int max = 0;
				int l_max = 0;
				int r_max = 0;
                
                // 왼쪽 두 건물 중 가장 큰 건물 찾기
				if (left1 > left2) {
					l_max = left1;
				} else {
					l_max = left2;
				}
				
                // 오른쪽 두 건물 중 가장 큰 건물 찾기
				if (right1 > right2) {
					r_max = right1;
				} else {
					r_max = right2;
				}
				
                // 왼쪽, 오른쪽 큰 건물 중에서 가장 큰 건물 찾기
				if (l_max > r_max) {
					max = l_max;
				} else {
					max = r_max;
				}
				
				if (cur > max) {  // 왼쪽, 오른쪽에서 가장 큰 건물이 현재 건물보다 크다면
					sum += cur - max;
				} else { 
					continue;
				}
			}
			
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}