import java.io.*;
import java.util.*;

public class Main {
	
	static List<ArrayList<Integer>> tree;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList<>();
		
		for (int i=0; i<N+1; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		
		visited = new boolean[N+1];
		
		int sum = 0;
		for (int i=1; i<N+1; i++) {
			if (!visited[i]) {
				sum += dfs(i);
			}
		}
		
		System.out.println(sum)	;

	}
	
	static int dfs(int start) {
		Deque<Integer> stack = new ArrayDeque<>();
		
		stack.offer(start);
		visited[start] = true;
		
		while (!stack.isEmpty()) {
			int node = stack.pollLast();
			
			for (int nextNode : tree.get(node)) {
				if (!visited[nextNode]) {
					stack.offer(nextNode);
					visited[nextNode] = true;
				}
			}
		}
		
		return 1;
	}

}
