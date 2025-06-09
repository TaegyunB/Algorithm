import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(input[j]);
				}
			}

			int[] monsterPos = findMonster(N, arr);

			for (int i = 0; i < 4; i++) {
				int ni = monsterPos[0] + di[i];
				int nj = monsterPos[1] + dj[i];

				while (ni >= 0 && ni < N && nj >= 0 && nj < N && arr[ni][nj] != 1) {
					arr[ni][nj] = 3;
					ni += di[i];
					nj += dj[i];
				}
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 0) {
						cnt++;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

	// 괴물 찾기
	static int[] findMonster(int N, int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 2) {
					return new int[] { i, j };
				}
			}
		}
		return null; // 괴물을 못 찾을 경우
	}
}
