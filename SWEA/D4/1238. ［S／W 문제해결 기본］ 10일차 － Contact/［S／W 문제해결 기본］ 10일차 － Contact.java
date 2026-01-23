import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int startNode = Integer.parseInt(st.nextToken());
			
			// 그래프 초기화: 인접 리스트 방식으로 구현
			// graph[i]는 i번 노드에서 연락 가능한 노드들의 리스트
			ArrayList<Integer>[] graph = new ArrayList[101];
			for (int i=0; i<=100; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from].add(to);
			}
			
			// BFS를 위한 큐 선언 (덱으로 구현)
			Deque<Integer> deque = new ArrayDeque<>();
			
			// 방문 체크 배열 (중복 방문 방지)
			boolean[] visited = new boolean[101];
			
			// 시작 노드를 큐에 추가하고 방문 처리
			deque.offerLast(startNode);
			visited[startNode] = true;
			
			int maxNum = 0;
			
			// BFS 시작: 레벨별로 처리하여 "동시에 연락받는" 개념 구현
			while (!deque.isEmpty()) {
				// 현재 레벨(시간)에 연락받을 사람의 수
				// 이 size 값이 핵심! 이만큼만 처리하면 한 레벨이 끝남
				int size = deque.size();
				maxNum = 0;
				
				// 현재 레벨의 모든 노드 처리 (동시에 연락받는 사람들)
				for (int i=0; i<size; i++) {
					int curNode = deque.pollFirst();  // 현재 레벨의 모든 노드 처리(동시에 연락받는 사람들)
					if (curNode > maxNum) {  // 현재 레벨에서 가장 큰 번호 갱신
						maxNum = curNode;
					}
					
					// 현재 노드에서 연락 가능한 모든 노드 탐색
					for (int nextNode : graph[curNode]) {
						// 아직 방문하지 않은 노드만 처리
						if (!visited[nextNode]) {
							deque.offerLast(nextNode);  // 다음 레벨(시간)에 연락받을 큐에 추가
							visited[nextNode] = true;
						}
					}
					
				}
			}
			
			sb.append("#").append(tc).append(" ").append(maxNum).append("\n");
		}
		
		System.out.println(sb);
	}
}