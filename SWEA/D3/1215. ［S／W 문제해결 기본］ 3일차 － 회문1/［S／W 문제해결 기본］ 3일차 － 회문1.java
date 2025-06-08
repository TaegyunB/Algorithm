import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];

			for (int i = 0; i < 8; i++) {
				String input = br.readLine();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = input.charAt(j);
				}
			}

			int total = 0;

			// 가로
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - N; j++) {
					boolean isPanlindrome = true;

					for (int k = 0; k < N / 2; k++) {
						if (arr[i][j + k] != arr[i][j + N - 1 - k]) {
							isPanlindrome = false;
							break;
						}
					}

					if (isPanlindrome) {
						total++;
					}
				}
			}

			// 세로
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - N; j++) {
					boolean isPanlindrome = true;

					for (int k = 0; k < N / 2; k++) {
						if (arr[j + k][i] != arr[j + N - 1 - k][i]) {
							isPanlindrome = false;
							break;
						}
					}

					if (isPanlindrome) {
						total++;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, total);
		}

	}
}
