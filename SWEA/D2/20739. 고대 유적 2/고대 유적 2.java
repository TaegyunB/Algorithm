import java.io.*;
import java.util.*;

public class Solution {
	
	// 우, 하
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};  

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][M];
		
			// 고대 유적 입력 
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxSum = 0;  // 가장 긴 구조물
			for (int x=0; x<N; x++) {
				for (int y=0; y<M; y++) {
					if (arr[x][y] == 1) {  // 구조물이 있는 곳을 발견하면
						
						for (int dir=0; dir<2; dir++) {  // 우, 하 만 확인하면 구할 수 있음
							int cnt = 1;
							int nx = x + dx[dir];
							int ny = y + dy[dir];
						
							while (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1) {  // 배열 범위 안에 있고 구조물이 있다면
								cnt++;
								nx += dx[dir];
								ny += dy[dir];
							}
							
							if (cnt > maxSum) {  // 가장 긴 구조물 갱신
								maxSum = cnt;
							}
						}
					}
				}
			}
			
			// 1 x 1의 경우 - 노이즈(0)
			if (maxSum == 1) {
				maxSum = 0;
			}
			
			sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
		}
		
		System.out.println(sb);
	}
}