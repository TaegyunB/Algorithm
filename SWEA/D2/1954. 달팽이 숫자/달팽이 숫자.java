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
			
			int i = 0, j = 0; 
			int num = 1;
			int dir = 0;
			
			while (num <= (N*N)) {
				arr[i][j] = num;
				num++;
				
				int ni = i + di[dir];
				int nj = j + dj[dir];
				
				if(ni < 0 || ni >= N || nj < 0 || nj >= N || arr[ni][nj] != 0) {
					dir = (dir + 1) % 4;
					ni = i + di[dir];
					nj = j + dj[dir];
				}
				
				i = ni;
				j = nj;
			}
			
			System.out.println("#" + tc);
			for(int x=0; x<N; x++) {
				for(int y=0; y<N; y++) {
					System.out.print(arr[x][y] + " ");
				}
				System.out.println();
			}
		}
	}
}

