import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());  // 가로, 세로 길이
			int K = Integer.parseInt(st.nextToken());  // 단어의 길이
			int[][] arr = new int[N][N];
			
			// 2차원 배열에 퍼즐 그리기
			for (int i=0; i<N; i++) {
				String[] input = br.readLine().split(" ");
				
				for (int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			// 단어가 들어갈 수 있는 부분은 1, 들어갈 수 없는 부분은 0
			
			// 가로
			int answer = 0;
			for (int x=0; x<N; x++) {
				for (int y=0; y<N; y++) {
					if (arr[x][y] == 1) {  // 단어가 들어갈 수 있는 부분이라면
						int cnt = 1;
						int ny = y+1;  // 다음에 단어가 들어갈 수 있는 지 확인하기 위한 y 변수
						
						while (ny >= 0 && ny < N && arr[x][ny] == 1) {  // 다음에 단어가 들어갈 수 있을 때 까지 확인
							cnt++;
							ny++; 
					
						}
						
						if (cnt == K) {  // 다 확인하고 들어갈 수 있는 단어의 개수가 K 값과 같다면
							answer++;  // 정답 값에 +1
						}
						
						y = ny;  // 끝난 지점을 y 값에 갱신
					}
				}
			}
			
			// 세로
			for (int y=0; y<N; y++) {
				for (int x=0; x<N; x++) {
					if (arr[x][y] == 1) {
						int cnt = 1;
						int nx = x+1;   // 다음에 단어가 들어갈 수 있는 지 확인하기 위한 x 변수
						
						while (nx >= 0 && nx < N && arr[nx][y] == 1) {  // 다음에 단어가 들어갈 수 있을 때 까지 확인
							cnt++;
							nx++;
						}

						if (cnt == K) { // 다 확인하고 들어갈 수 있는 단어의 개수가 K 값과 같다면
							answer++;  // 정답 값에 +1
						}
						
						x = nx;  // 끝난 지점을 x 값에 갱신
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
