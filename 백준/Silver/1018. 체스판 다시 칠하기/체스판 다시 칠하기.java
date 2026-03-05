import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] chess = new char[N][M];
		
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			
			for (int j=0; j<M; j++) {
				chess[i][j] = input.charAt(j);
			}
		}
		
		// repaint 최소 횟수
		int ans = Integer.MAX_VALUE;
		
		// 8x8 체스판을 만들 수 있는 모든 시작점 탐색
		// i, j는 8x8 체스판의 왼쪽 위 좌표
		for (int i=0; i<=N-8; i++) {
			for (int j=0; j<=M-8; j++) {
				
				int w = 0;  // 왼쪽 위가 W로 시작하는 체스판으로 만들 때 repaint 횟수
				int b = 0;  // 왼쪽 위가 B로 시작하는 체스판으로 만들 때 repaint 횟수
				for (int k=i; k<i+8; k++) {
					for (int l=j; l<j+8; l++) {
						
						// 8x8 내부 좌표
						int di = k - i;
						int dj = l - j;
						
						// W로 시작하는 체스판일 때 해당 위치에 와야 하는 색
						char expectedW = (di + dj) % 2 == 0 ? 'W' : 'B';
						
						// B로 시작하는 체스판일 때 해당 위치에 와야 하는 색
						char expectedB = (di + dj) % 2 == 0 ? 'B' : 'W';
						
						// 현재 색이 W 시작 체스판과 다르면 repaint 필요
						if (chess[k][l] != expectedW) {
							w++;
						}
						
						// 현재 색이 B 시작 체스판과 다르면 repaint 필요
						if (chess[k][l] != expectedB) {
							b++;
						}
					}
				}
				
				// 두 패턴 중 repaint 횟수가 더 작은 것을 선택
				ans = Math.min(ans, Math.min(w, b));
			}
		}
		
		System.out.println(ans);
	}
	
}
