import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			String[] input = br.readLine().split(" ");
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			
			int i_count = 0;
			for(int i=0; i<N; i++) {
				int j_count = 0;
				for(int j=i+1; j<N; j++) {
					if(arr[i] > arr[j]) {
						j_count++;
					}
				}
				
				if(j_count > i_count) {
					i_count = j_count;
				}
			}
			System.out.printf("#%d %d\n", tc, i_count);
		}
	}
}
