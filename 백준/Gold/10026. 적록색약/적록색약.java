import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = new int[]{0, 1, 0, -1};
	static int[] dy = new int[]{1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			char[] inputChar = input.toCharArray();
			
			for (int j=0; j<N; j++) {
				arr[i][j] = inputChar[j];
			}
		}
		
		boolean[][] visited = new boolean[N][N];
		int red = 0;
		int green = 0;
		int blue = 0;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				Deque<Pos> queue = new ArrayDeque<>();
				
				if (!visited[i][j]) {
					queue.offer(new Pos(i, j));
					visited[i][j] = true;
					
					if (arr[i][j] == 'R') {
						red++;
					} else if( arr[i][j] == 'B') {
						blue++;
					} else {
						green++;
					}
					
					while (!queue.isEmpty()) {
						Pos pos = queue.poll();
						int x = pos.x;
						int y = pos.y;
						
						for (int k=0; k<4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[i][j] == arr[nx][ny] && !visited[nx][ny]) {
								visited[nx][ny] = true;
								queue.offer(new Pos(nx, ny));
							}
						}
					}
				}
			}
		}
		
		int colorSum = red + green + blue;
		
		visited = new boolean[N][N];
		int redAndGreen = 0;
		blue = 0;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				Deque<Pos> queue = new ArrayDeque<>();
				
				if (!visited[i][j]) {
					queue.offer(new Pos(i, j));
					visited[i][j] = true;
					
					if (arr[i][j] == 'R' || arr[i][j] == 'G') {
						redAndGreen++;
					} else {
						blue++;
					}
					
					while (!queue.isEmpty()) {
						Pos pos = queue.poll();
						int x = pos.x;
						int y = pos.y;
						
						for (int k=0; k<4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
								if (arr[x][y] == 'R' || arr[x][y] == 'G') {
									if (arr[nx][ny] == 'R' || arr[nx][ny] == 'G') {
										visited[nx][ny] = true;
										queue.offer(new Pos(nx, ny));
									}
								} else if (arr[x][y] == 'B') {
									if (arr[nx][ny] == 'B') {
										visited[nx][ny] = true;
										queue.offer(new Pos(nx, ny));
									}
								}
							}
						}
					}
				}
			}
		}
		
		int nonColorSum = redAndGreen + blue;
		
		System.out.println(colorSum + " " + nonColorSum);
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
