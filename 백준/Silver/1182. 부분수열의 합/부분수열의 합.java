import java.io.*;
import java.util.*;

public class Main {

	static int N, S;
	static int[] arr;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 완전 탐색(브루트포스)
		dfs(0, 0);
		
		if (S == 0) {  // S가 0으로 시작하면 공집합일 때도 cnt가 +1로 되기 때문에 cnt-- 해주기
			cnt--;
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int index, int sum) {
		if (index == N) {
			if (sum == S) {
				cnt++;
			}
			
			return;
		}
		
		dfs(index + 1, sum + arr[index]);  // 부분수열에 포함
		dfs(index + 1, sum);  // 부분수열에 미포함
	}
}
