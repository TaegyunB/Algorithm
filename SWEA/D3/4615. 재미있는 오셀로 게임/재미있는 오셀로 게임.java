import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] dx = {0, 1, 0, -1, 1, -1, -1, 1};
	static int[] dy = {1, 0, -1, 0, 1, 1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			
			// 1: 흑, 2: 백
			if (N == 4) {
				arr[1][1] = 2;
				arr[1][2] = 1;
				arr[2][1] = 1;
				arr[2][2] = 2;
			} else if (N == 6) {
				arr[2][2] = 2;
				arr[2][3] = 1;
				arr[3][2] = 1;
				arr[3][3] = 2;
			} else if (N == 8) {
				arr[3][3] = 2;
				arr[3][4] = 1;
				arr[4][3] = 1;
				arr[4][4] = 2;
			}
			
			// 오셀로 게임 시작
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int color = Integer.parseInt(st.nextToken());
				
				arr[x][y] = color;  // 돌 배치
				
				for (int dir=0; dir<8; dir++) {  // 8 방향을 보면서
					int nx = x + dx[dir];
					int ny = y + dy[dir];
				
					int save_nx = dx[dir];
					int save_ny = dy[dir];
					int cnt = 0;
					boolean flag = false;
					
					while (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] != 0) {  // 다음 위치에 있는 돌이 비어있지 않고 자신의 돌 색상이랑 다르다면
						if (arr[nx][ny] == color) {
							flag = true;
							break;
						}
						else if (arr[nx][ny] != color) {
							nx += dx[dir];
							ny += dy[dir];
							cnt++;
						}	
					}
					
					if (flag) {						
						nx = x + save_nx;
						ny = y + save_ny;
						for (int j=0; j<cnt; j++) {
							arr[nx][ny] = color;
							nx += save_nx;
							ny += save_ny;
						}
					}
				}
			}
			
			// 돌 개수 세기
			int white = 0;
			int black = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (arr[i][j] == 1) {
						black++;
					} else if (arr[i][j] == 2) {
						white++;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(black).append(" ").append(white).append("\n");
		}
		
		System.out.println(sb);
	}
}
