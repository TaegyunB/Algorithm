import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[16][16];
			
			
			// 배열 채우기
			for (int i=0; i<16; i++) {
				String input = br.readLine();
				
				for (int j=0; j<16; j++) {
					arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
				}
			}
			
			sb.append("#").append(tc).append(" ");
			
			int[] pos = findStart(arr, 16);  // 시작지점 찾기 함수
			int x = pos[0];  // 시작 지점의 x
			int y = pos[1];  // 시작 지점의 y
			
			boolean[][] visited = new boolean[16][16];  // 방문 여부 확인 배열
			boolean found = false;

			Deque<Integer> deque = new ArrayDeque<>();  // BFS 탐색을 위한 deque 선언
			deque.offerLast(x);  // 뒤에서부터 x값 추가
			deque.offerLast(y);  // 뒤에서부터 y값 추가
			
			visited[x][y] = true;  // 2의 값에 방문 했다는 것을 표시
			
			while(!deque.isEmpty()) {  // deque가 비어있지 않는 동안
				int xx = deque.pollFirst();  // 앞에서 x 값을 빼오기
				int yy = deque.pollFirst();  // 앞에서 y 값을 빼오기
				
				if (arr[xx][yy] == 3) {  // 종료 시점 - 3을 찾았으면 길이 있다는 뜻이기 때문에
					found = true;  // found를 true로 변경
					break;  // while문 나오기
				}
				
				for (int z=0; z<4; z++) {  // 우, 하, 좌, 상을 돌면서
					int nx = xx + dx[z];
					int ny = yy + dy[z];
					
					if (nx >= 0 && nx < 16 && ny >= 0 && ny < 16 && arr[nx][ny] != 1 && !visited[nx][ny]) {  // 범위 안에 있고 벽이 아니고 방문한 적이 없다면
						deque.offerLast(nx);  // 뒤에서 새로운 x 값을 추가
						deque.offerLast(ny);  // 뒤에서 새로운 y 값을 추가
						visited[nx][ny] = true;  // 방문 표시
					}
				}
			}
			
			if (found) {  // 길을 찾았다면 sb에 1 추가
				sb.append(1).append("\n");
			}
			else {  // 길을 찾지 못했다면 sb에 0 추가
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	// 시작 지점 찾기
	static int[] findStart(int[][] arr, int N) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (arr[i][j] == 2) {
					return new int[] {i, j};  // 찾았다면 i, j 값을 반환
				}
			}
		}
		
		return new int[] {-1, -1};  // 찾지 못했을 때의 반환값
	}
}