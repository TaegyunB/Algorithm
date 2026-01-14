import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			int tcNum = Integer.parseInt(br.readLine());
			
			// 각 행의 합을 저장하는 배열
			int[] rowSum = new int[100];
			
			// 각 열의 합을 저장하는 배열
			int[] colSum = new int[100];
			
			// 왼쪽 위 -> 오른쪽 아래 대각선 합
			int diag1 = 0;
			
			// 오른쪽 위 -> 왼쪽 아래 대각선 합
			int diag2 = 0;
			
			// 모든 합 중 최대값
			int maxSum = 0;
			
			// 100 x 100 배열에 값 추가
			for (int i=0; i<100; i++) {
//				String[] numList = br.readLine().split(" ");
				StringTokenizer st = new StringTokenizer(br.readLine());  // split 보다 빠름
				
				for (int j=0; j<100; j++) {
					int v = Integer.parseInt(st.nextToken());
					
					rowSum[i] += v;  // i번째 행의 합 누적
					colSum[j] += v;  // j번째 행의 합 누적
					
					// 왼쪽 위 -> 오른쪽 아래 대각선
					if (i == j) {
						diag1 += v;
					} 
					
					// 오른쪽 위 -> 왼쪽 아래 대각선
					if (i + j == 99) {
						diag2 += v;
					}
				}

				// 현재까지 누적된 행/열/대각선 합 중 최대값 갱신
				for (int x=0; x<100; x++) {
					
					// 행의 합 중 최대
					if (rowSum[x] > maxSum) {
						maxSum = rowSum[x];
					}
					
					// 열의 합 중 최대
					if (colSum[x] > maxSum) {
						maxSum = colSum[x];
					}
					
					// 첫 번째 대각선과 비교
					if (diag1 > maxSum) {
						maxSum = diag1;
					}
					
					// 두 번째 대각선과 비교
					if (diag2 > maxSum) {
						maxSum = diag2;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
			
		}
		
		System.out.println(sb);
	}
}