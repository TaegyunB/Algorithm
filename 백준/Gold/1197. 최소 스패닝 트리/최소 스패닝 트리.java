import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		
		parent = new int[V+1];
		
		for (int i=0; i<=V; i++) {
			parent[i] = i;
		}
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			pq.offer(new Pos(start, end, cost));
		}
		
		int result = 0;
		while (!pq.isEmpty()) {
			Pos pos = pq.poll();
			int start = pos.start;
			int end = pos.end;
			int cost = pos.cost;
			
			if (find(start) != find(end)) {  // 사이클 방지
				union(start, end);
				result += cost;
			}
		}
		
		System.out.println(result);
	}
	
	static class Pos implements Comparable<Pos>{
		int start;
		int end;
		int cost;
		
		public Pos(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		
		}
		
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			parent[b] = a;			
		}
	}
	
}
