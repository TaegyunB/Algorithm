import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;  // 구간 왼쪽 포인터
		int r = 0;  // 구간 오른쪽 포인터
		int sum = 0;  // 현재 구간 (l, r의 합)
		int cnt = 0;  // 합이 M인 경우의 수
		
		while (r <= N) {
			if (sum == M) {  // 합이 M과 같으면 경우의 수 증가 후 구간 왼쪽 축소
				cnt++;
				sum -= arr[l];
				l++;
			} else if (sum < M) {  // 합이 M보다 작으면 r이 끝에 도달했는지 확인 구간 오른쪽 확장
				if (r == N) {
					break;  // r이 배열 끝이면 더 확장 불가 -> 종료
				}
				sum += arr[r];
				r++;
			} else if (sum > M) {  // 합이 M보다 크면 구간 왼쪽 축소
				sum -= arr[l];
				l++;
			}
		}

		System.out.println(cnt);
	}

}
