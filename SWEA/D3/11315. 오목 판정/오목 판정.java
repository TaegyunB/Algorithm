import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

	// 오른쪽, 아래, 오른쪽 아래 대각선, 왼쪽 아래 대각선
	static int[] di = { 0, 1, 1, 1 };
	static int[] dj = { 1, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = line.charAt(j);
				}
			}

			boolean found = false;

			/*
			 * outer: 특정 반복문 블록에 이름을 붙여서 break나 continue할 때 바로 해당 반복문을 빠져나갈 수 있게 해줌
			 */
			outer: // 3중 루프 break를 위한 라벨
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != 'o')
						continue;

					for (int dir = 0; dir < 4; dir++) {
						int cnt = 1;
						int ni = i + di[dir];
						int nj = j + dj[dir];

						while (ni >= 0 && ni < N && nj >= 0 && nj < N && arr[ni][nj] == 'o') {
							cnt++;
							if (cnt >= 5) {
								found = true;
								break outer; // 5개 이상 발견하면 바로 전체 루프 탈출
							}
							ni += di[dir];
							nj += dj[dir];
						}
					}
				}
			}
			
			if(found) {
				System.out.printf("#%d YES\n", tc);
			} else {
				System.out.printf("#%d NO\n", tc);
			}
		}
	}
}
