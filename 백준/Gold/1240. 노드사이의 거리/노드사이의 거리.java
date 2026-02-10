import java.io.*;
import java.util.*;

public class Main {
	
	ArrayList<ArrayList<Pos>> tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Pos>> tree = new ArrayList<>();
		
		for (int i=0; i<=N; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			tree.get(startNode).add(new Pos(endNode, dist));
			tree.get(endNode).add(new Pos(startNode, dist));
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[N+1];
			
			int result = bfs(startNode, endNode, tree, visited);
			
			System.out.println(result);
		}
		
	}
	
	static class Pos {
		int endNode;
		int dist;
		
		public Pos(int endNode, int dist) {
			this.endNode = endNode;
			this.dist = dist;
		}
	}
	
	static int bfs(int startNode, int endNode, ArrayList<ArrayList<Pos>> tree, boolean[] visited) {
		Deque<Pos> queue = new ArrayDeque<>();
		queue.offer(new Pos(startNode, 0));
		visited[startNode] = true;
		
		while (!queue.isEmpty()) {
			Pos pos = queue.poll();
			int node = pos.endNode;
			int dist = pos.dist;
			
			if (node == endNode) {
				return dist;
			}
			
			for (Pos next : tree.get(node)) {
				if (!visited[next.endNode]) {
					visited[next.endNode] = true;
					queue.offer(new Pos(next.endNode, dist + next.dist));		
				}
			}
		}
		return -1;
	}

}
