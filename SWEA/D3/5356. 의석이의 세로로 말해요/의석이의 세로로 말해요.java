import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ArrayList<String> arr = new ArrayList<>();

			int max_length = 0;

			for (int i = 0; i < 5; i++) {
				String input = br.readLine();
				arr.add(input);

				if (input.length() > max_length) {
					max_length = input.length();
				}
			}

			System.out.printf("#%d ", tc);
			for (int j = 0; j < max_length; j++) { // 열 기준 반복
				for (int i = 0; i < 5; i++) { // 행 기준 반복
					if (arr.get(i).length() <= j) {
						continue; // 해당 행의 j번째 글자가 없으면 건너뜀
					}
					System.out.print(arr.get(i).charAt(j));
				}
			}
			System.out.println();
		}
	}
}
