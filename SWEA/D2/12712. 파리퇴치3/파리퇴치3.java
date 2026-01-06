import java.io.*;
import java.util.*;

public class Solution {
	
	// + 방향
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	// x 방향
	static int[] di = {1, -1, -1, 1};
	static int[] dj = {1, 1, -1, -1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			for (int i=0; i<N; i++) {
				String[] input = br.readLine().split(" ");
				
				for (int j=0; j<input.length; j++) {
					arr[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			int max_sum = 0;
			
			// + 방향에서 최대값 구하기
			for (int x=0; x<N; x++) {				
				for (int y=0; y<N; y++) {
					int sum = arr[x][y];  // 현재 위치(중앙)의 파리 수 포함
					
					for (int k=0; k<4; k++) {  // 4 방향 (상, 하, 좌, 우)
						int nx = x;
						int ny = y;
					
						for (int l=0; l<M-1; l++) {  // M 만큼 스프레이를 뿌림
							nx += dx[k];
							ny += dy[k];
							
							if (nx >= 0 && nx < N && ny >= 0 && ny < N) {  // N 범위 안에 있을 때만
								sum += arr[nx][ny];  // 파리 값 더하기						
							}
						}
					}
					
					// 최대값 갱신
					if (sum > max_sum) {
						max_sum = sum;
					}
				}
			}
			
			// x 방향에서 최대값 구하기
			for (int i=0; i<N; i++) {				
				for (int j=0; j<N; j++) {
					int sum = arr[i][j];  // 현재 위치(중앙)의 파리 수 포함
					
					for (int k=0; k<4; k++) {  // 4 방향 (상, 하, 좌, 우)
						int ni = i;
						int nj = j;
					
						for (int l=0; l<M-1; l++) {  // M 만큼 스프레이를 뿌림
							ni += di[k];
							nj += dj[k];
							
							if (ni >= 0 && ni < N && nj >= 0 && nj < N) {  // N 범위 안에 있을 때만
								sum += arr[ni][nj];  // 파리 값 더하기				
							}
						}
					}
					
					// 최대값 갱신
					if (sum > max_sum) {
						max_sum = sum;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, max_sum);	
		}
	}
}