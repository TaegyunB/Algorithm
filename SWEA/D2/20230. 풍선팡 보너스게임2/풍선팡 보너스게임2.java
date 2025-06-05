import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
	
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String[] line = br.readLine().split(" ");
				
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(line[j]);
				}
			}
			
			int max_sum = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					int sum = arr[i][j];
					for(int k=0; k<4; k++) {
						int ni = i + di[k];
						int nj = j + dj[k];
						
						while(ni >= 0 && ni < N && nj >= 0 && nj < N) {
							sum += arr[ni][nj];
							ni += di[k];
							nj += dj[k];
						} 
					}
					
					if(sum > max_sum) {
						max_sum = sum;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, max_sum);
		}
		
	}
}

