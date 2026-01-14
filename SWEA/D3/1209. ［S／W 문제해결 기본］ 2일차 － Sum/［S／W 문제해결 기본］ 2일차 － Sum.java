import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			int tcNum = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			
			// 100 x 100 배열에 값 추가
			for (int i=0; i<100; i++) {
				String[] numList = br.readLine().split(" ");
				
				for (int j=0; j<numList.length; j++) {
					arr[i][j] = Integer.parseInt(numList[j]);
				}
			}
			
			int maxSum = 0;  // 최대값
			
			// 행의 합
			for (int x=0; x<100; x++) {
				int sum = 0;
				
				for (int y=0; y<100; y++) {
					sum += arr[x][y]; 
				}
				
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
			
			// 열의 합
			for (int y=0; y<100; y++) {
				int sum = 0;
				
				for (int x=0; x<100; x++) {
					sum += arr[x][y];
				}
				
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
			
			// 오른쪽 아래 대각선의 합
			int rightCrossSum = 0;
			for (int x=0; x<100; x++) {
				rightCrossSum += arr[x][x];
			}
			
			if (rightCrossSum > maxSum) {
				maxSum = rightCrossSum;
			}
			
			// 왼쪽 아래 대각선의 합
			int leftCrossSum = 0;
			for (int x=99; x>=0; x--) {
				leftCrossSum += arr[x][99-x];
			}
			
			if (leftCrossSum > maxSum) {
				maxSum = leftCrossSum;
			}
			
			sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
		}
		
		System.out.println(sb);
	}
}
