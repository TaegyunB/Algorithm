import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] stairs = new int[n+1];
		int[] dp = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			stairs[i] = Integer.parseInt(st.nextToken());
		}
		
        dp[0] = 0;
        
		// 초기값을 n 크기에 맞게 조건 처리
		if (n >= 1) {
			dp[1] = stairs[1];
		}
		
		if (n >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}
		
		for (int i=0; i<n-2; i++) {
			dp[i+3] = Math.max(dp[i+1] + stairs[i+3], dp[i] + stairs[i+2] + stairs[i+3]);
		}
		
		System.out.println(dp[n]);
	}

}
