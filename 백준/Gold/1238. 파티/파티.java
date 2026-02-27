import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static List<ArrayList<Pos>> tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 학생 수
		int M = Integer.parseInt(st.nextToken());  // 단방향 도로 수
		int X = Integer.parseInt(st.nextToken());  // 파티 장소
		

		tree = new ArrayList<>();
		
		for (int i=0; i<=N; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			tree.get(start).add(new Pos(end, cost));
		}
		
		int answer = 0;
		for (int i=1; i<=N; i++) {
			int[] homeToParty = Dijkstra(i);  // 집에서 파티로 출발
			int[] partyToHome = Dijkstra(X);  // 파티에서 집으로 출발
			
			answer = Math.max(answer, homeToParty[X] + partyToHome[i]);
		}

		System.out.println(answer);
	}
	
	static class Pos implements Comparable<Pos>{
		int end;
		int cost;
		
		public Pos(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.cost, o.cost);
		}
		
		@Override
		public String toString() {
			return end + " " + cost;
		}
	}
	
	// 다익스트라
	static int[] Dijkstra(int startNode) {
		
		PriorityQueue<Pos> q = new PriorityQueue<>();
		
		int costs[] = new int[N+1];
		for (int i=1; i<N+1; i++) {
			costs[i] = Integer.MAX_VALUE;
		}
		
		q.offer(new Pos(startNode, 0));
		costs[startNode] = 0;
		
		while (!q.isEmpty()) {
			Pos pos = q.poll();
			int node = pos.end;
			int cost = pos.cost;
			
			if (cost > costs[node]) {
				continue;
			}
			
			for (Pos nextPos : tree.get(node)) {
				int nextNode = nextPos.end;
				int nextCost = nextPos.cost + cost;
				
				if (costs[nextNode] > nextCost) {
					costs[nextNode] = nextCost;
					q.offer(new Pos(nextNode, nextCost));
				}
					
			}	
		}
		
		return costs;
	}
}
