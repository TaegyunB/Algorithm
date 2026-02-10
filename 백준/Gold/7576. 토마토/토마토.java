import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = new int[]{0, 1, 0, -1};
	static int[] dy = new int[] {1, 0, -1, 0}; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		Deque<Pos> queue = new ArrayDeque<>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				
				if (num == 1) {  // 1이면 익은 토마토의 위치니깐 queue에 추가
					queue.offer(new Pos(i, j));
				}
			}
		}
		
		while (!queue.isEmpty()) {
			Pos pos = queue.poll();
			int x = pos.x;
			int y = pos.y;
			
			for (int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (arr[nx][ny] == 0) {
						arr[nx][ny] += arr[x][y] + 1;						
						queue.offer(new Pos(nx, ny));

					}
				}
			}
		}
		
		int maxNum = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				maxNum = Math.max(maxNum, arr[i][j]);
			}
		}
		
		if (maxNum == 1) {
			System.out.println(0);
		} else {
			System.out.println(maxNum-1 );			
		}
		

	}

	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		

	    @Override
	    public String toString() {
	        return "(" + x + "," + y + ")";
	    }
	}
}
