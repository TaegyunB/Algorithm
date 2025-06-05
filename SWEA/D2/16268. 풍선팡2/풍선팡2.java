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
			String[] xy = br.readLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			
			int[][] arr = new int[x][y];
			
			for(int i=0; i<x; i++) {
				String[] line = br.readLine().split(" ");
				for(int j=0; j<y; j++) {
					arr[i][j] = Integer.parseInt(line[j]);
					
				}
			}
			
			int max_sum = 0;
			for(int i=0; i<x; i++) {
				for(int j=0; j<y; j++) {
					int sum = arr[i][j];
					
					for(int k=0; k<4; k++) {
						int ni = i + di[k];
						int nj = j + dj[k];
						
						for(int l=0; l<1; l++) {
							if(ni >= 0 && ni < x && nj >= 0 && nj < y) {
								sum += arr[ni][nj];
							}
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

