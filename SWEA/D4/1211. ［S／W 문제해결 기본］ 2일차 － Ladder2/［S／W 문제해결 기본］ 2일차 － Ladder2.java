import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String[] input = br.readLine().split(" ");

				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(input[j]);
				}
			}

			int min_cnt = 10000;
			int answer = 0;
			for (int y = 0; y < 100; y++) {
				int x = 0;
				if (arr[x][y] == 1) {
					int ni = x + 1;
					int nj = y + 0;
					int cnt = 1;

					while (ni < 100) {

						// 왼쪽
						if (nj - 1 >= 0 && arr[ni][nj - 1] == 1) {
							while (nj - 1 >= 0 && arr[ni][nj - 1] == 1) {
								nj--;
								cnt++;
							}
						}
						// 오른쪽
						else if (nj + 1 < 100 && arr[ni][nj + 1] == 1) {
							while (nj + 1 < 100 && arr[ni][nj + 1] == 1) {
								nj++;
								cnt++;
							}
						}

						// 아래
						ni++;
						cnt++;
					}

					if (cnt < min_cnt) {
						min_cnt = cnt;
						answer = y;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

	}
}
