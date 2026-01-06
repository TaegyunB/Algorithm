import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int[] busStation = new int[5001];  // 총 버스 정류장
			
			for (int i=0; i<N; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				for (int j=A; j<=B; j++) {
					busStation[j]++;
				}
			}
			
			int P = sc.nextInt();  // 버스 정류장
			System.out.printf("#%d ", tc);
			
			// 출력하고 싶은 버스정류장 입력 후 값 출력
			for (int i=0; i<P; i++) {
				
				int busNum = sc.nextInt();
				System.out.printf("%d ", busStation[busNum]);
			}
			
			System.out.println();  // 다음 테스트케이스를 위해 줄바꿈
		}
	}
}
