import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = new int[] {0, 1, 0, -1};
	static int[] dy = new int[] {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			
			for (int j=0; j<M; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		boolean[][] visited = new boolean[N][M];
		
		Deque<Pos> queue = new ArrayDeque<>();
		queue.offer(new Pos(0, 0));
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			Pos pos = queue.poll();
			int x = pos.x;
			int y = pos.y;
			
			for (int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && arr[nx][ny] == 1) {
					queue.offer(new Pos(nx, ny));
					visited[nx][ny] = true;
					arr[nx][ny] = arr[x][y] + 1;
				}
			}
		}
		
		System.out.println(arr[N-1][M-1]);
	}
	
	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}