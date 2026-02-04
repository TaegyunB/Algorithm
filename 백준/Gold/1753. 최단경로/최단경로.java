import java.io.*;
import java.util.*;

public class Main {
	
	static int[] costs;  // 시작점부터 각 정점까지의 최단 거리를 저장하는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());  // 정점
		int E = Integer.parseInt(st.nextToken());  // 간선
		
		int startNode = Integer.parseInt(br.readLine());
		
		// 최단 거리 배열 초기화
		costs = new int[V+1];
		for (int i=0; i<V+1; i++) {
			costs[i] = Integer.MAX_VALUE;
		}
		
		// 인접 리스트 생성 (각 정점마다 연결된 간선 정보를 저장)
		List<ArrayList<Node>> list = new ArrayList<>();
		for (int i=0; i<V+1; i++) {
			list.add(new ArrayList<>());  // 각 정점마다 빈 리스트 생성
		}
		
		// 우선순위 큐 생성 (비용이 적은 것부터 처리)
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		
		// 간선 정보 입력받기
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// start 정점에서 end 정점으로 가는 간선 추가
			list.get(start).add(new Node(end, cost));
		}
		
		// 시작 정점을 큐에 추가 (시작점의 거리는 0)
		pq.offer(new Node(startNode, 0));
		costs[startNode] = 0;
		
		// 다익스트라 알고리즘 실행
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int start = node.end;
			int cost = node.cost;
			
			// 현재 정점에서 연결된 모든 간선 확인
			for (Node next : list.get(start)) {
				int nexEndNode = next.end;
				int nextEndCost = cost + next.cost;
				
				// 더 짧은 경로를 발견한 경우
				if (nextEndCost < costs[nexEndNode]) {
					costs[nexEndNode] = nextEndCost;  // 최단 거리 갱신
					pq.offer(new Node(nexEndNode, nextEndCost));  // 큐에 추가
				}
			}
		}
		
		for (int i=1; i<=V; i++) {
			if (costs[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(costs[i] + "\n");
			}
		}
		
		System.out.println(sb);
	}
	
	// 간선 정보를 담는 노드 클래스
	static class Node {
		int end;
		int cost;
		
		Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
}