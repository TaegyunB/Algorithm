import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static List<ArrayList<Integer>> tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		tree = new ArrayList<>();
		
		for (int i=0; i<N+1; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			tree.get(start).add(end);
			tree.get(end).add(start);
		}
		
		int sum = dfs(1);
		
		System.out.println(sum);
	}

	static int dfs(int x) {
		Deque<Integer> stack = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		stack.offer(x);
		visited[x] = true;
		
		int cnt = 0;
		while (!stack.isEmpty()) {
			int node = stack.pollLast();
			
			for (int nextNode : tree.get(node)) {
				if (!visited[nextNode]) {
					stack.offer(nextNode);
					visited[nextNode] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}
