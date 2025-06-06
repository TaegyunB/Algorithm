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

			for (int y = 0; y < 100; y++) {
				int x = 0;
				if (arr[x][y] == 1) {
					int ni = x + 1;
					int nj = y + 0;

					while (ni < 100) {

						// 왼쪽
						if (nj - 1 >= 0 && arr[ni][nj - 1] == 1) {
							while (nj - 1 >= 0 && arr[ni][nj - 1] == 1) {
								nj--;
							}
						}
						// 오른쪽
						else if (nj + 1 < 100 && arr[ni][nj + 1] == 1) {
							while (nj + 1 < 100 && arr[ni][nj + 1] == 1) {
								nj++;
							}
						}

						// 아래
						ni++;
					}

					if (arr[ni - 1][nj] == 2) {
						System.out.printf("#%d %d\n", tc, y);
						break;
					}
				}
			}
		}

	}
}
