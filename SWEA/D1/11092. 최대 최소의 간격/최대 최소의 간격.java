import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for (int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int min = arr[0];  // 최소값
			int max = arr[0];  // 최대값
			int min_index = 0;  // 최소값 인덱스
			int max_index = 0;  // 최대값 인덱스
			
			for (int i=1; i<N; i++) {
				if (arr[i] < min) {  // 현재 값이 최소값보다 작다면
					min = arr[i];  // 최소값 갱신
					min_index = i;  // 최소값 인덱스 갱신
				}
				else if (arr[i] >= max) {  // 현재 값이 최대값보다 크거나 같다면
					max = arr[i];  // 최대값 갱신
					max_index = i;  // 최대값 인덱스 갱신
				}
			}
			
			int answer = Math.abs(max_index - min_index);  // 절대값 구하기
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
