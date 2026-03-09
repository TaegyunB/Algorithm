import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;
		int r = 0;
		int sum = 0;
		int minL = Integer.MAX_VALUE;
		
		while (r <= N) {
			if (sum >= S) {
				int sub = r - l;
				if (sub < minL) {
					minL = sub;
				}
				
				sum -= arr[l];
				l++;				

			} else if (sum < S) {
				if (r == N) {
					break;
				}
				sum += arr[r];
				r++;
			}
		}
		
		if (minL == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(minL);			
		}
	}
}
