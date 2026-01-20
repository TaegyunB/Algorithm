import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			
			// 핵심 아이디어: 각 열을 위에서 아래로 탐색
			// 1이 아래로 이동하다가 2를 만나면 교착 상태 발생
			for (int y=0; y<N; y++) {
				for (int x=0; x<N; x++) {
					if (arr[x][y] == 1) {  // 1(N극 성질)을 발견하면
						
						// 아래로 탐색 시작
						int nx = x+1;
						int ny = y;
						
						// 테이블 범위 내 있을 때까지
						while (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {  
							if (arr[nx][ny] == 2) {  // 2(S극 성질)과 만나면
								answer++;  // 교착 상태 카운트
								break;  // 이 열에서 더 이상 탐색 불필요하기 때문에 while문 빠져나오기
							}
							else if (arr[nx][ny] == 1) {  // 또 다른 1을 만나면 더 이상 탐색이 필요없음 -> 방금 만난 1에서부터 다시 탐색해야되기 때문
								break;
							}
							
							nx++;  // 계속 아래로 이동
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append('\n');
		}
		
		System.out.println(sb);
	}
}