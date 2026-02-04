import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] costs;  // 각 위치까지의 최소 복구 시간을 저장하는 배열
	// 4방향 탐
	static int[] dx = new int[]{0, 1, 0, -1};  
	static int[] dy = new int[] {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for (int i=0; i<N; i++) {
				String road = br.readLine();
				for (int j=0; j<N; j++) {
					arr[i][j] = road.charAt(j) - '0';
				}
			}
			
			// 우선순위 큐 생성 -> 복구 시간이 적은 것부터 처리
			PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
			costs = new int[N][N];
			
			// costs 배열을 무한대로 초기화
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					costs[i][j] = Integer.MAX_VALUE;
				}
			}
			
			// 시작점 (0, 0)을 큐에 추가, 시작점의 복구 시간은 0
			pq.offer(new Node(0, 0, 0));
			costs[0][0] = 0;
			
			// 다익스트라 알고리즘 실행
			while (!pq.isEmpty()) {
				Node node = pq.poll();  // 복구 시간이 가장 적은 노드를 꺼냄
				int x = node.x;  // 현재 x 좌표
				int y = node.y;  // 현재 y 좌표
				int cost = node.cost;  // 현재까지의 누적 복구 시간
				
				// 상하좌우 4방향 탐색
				for (int i=0; i<4; i++) {
					int nx = x + dx[i];  // 다음 x 좌표
					int ny = y + dy[i];  // 다음 y 좌표
					
					// 범위 체크
					if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
						// 현재 경로를 통한 복구 시간이 기존에 저장된 시간보다 적으면
						if (cost + arr[nx][ny] < costs[nx][ny]) {
							costs[nx][ny] = cost + arr[nx][ny];  // 최소 복구 시간 갱신
							pq.offer(new Node(nx, ny, costs[nx][ny]));  // 큐에 추가
						}
					}
				}
			}
			
			// 도착지 (N-1, N-1)까지의 최소 복구 시간
			int answer = costs[N-1][N-1];
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 노드 클래스: 위치(x, y)와 누적 복구 시간(cost)을 저장
	static class Node {
		int x;
		int y;
		int cost;
		
		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}