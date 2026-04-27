import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		for (int tc=0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			boolean found = true;
			
			long maxA = 0;
			long maxB = 0;
			long maxC = 0;
			
			for (int tn=1; tn<=n; tn++) {
				st = new StringTokenizer(br.readLine());
				long a = Long.parseLong(st.nextToken());
				long b = Long.parseLong(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				long p = Long.parseLong(st.nextToken());
				
				maxA = Math.max(maxA, a);
				maxB = Math.max(maxB, b);
				maxC = Math.max(maxC, c);
				
				if (found && tn + maxA + maxB + maxC > p) {
					found = false;
				}
			}
			
			if (found) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
	}

}
