import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class Main {

	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);
		
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		// 인접 리스트 초기화
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<M; i++) {
			String[] adj_node = br.readLine().split(" ");
			int node1 = Integer.parseInt(adj_node[0]);
			int node2 = Integer.parseInt(adj_node[1]);
			
			tree[node1].add(node2);
			tree[node2].add(node1);
		}
		
		// 정렬
		for(int i=1; i<=N; i++) {
			Collections.sort(tree[i]);
		}
		
		dfs(V);
		System.out.println();
		
		visited = new boolean[N+1];
		bfs(V);
	}
	
	// dfs 함수
	public static void dfs(int root) {
		visited[root] = true;
		System.out.print(root + " ");
		
		for(int node : tree[root]) {
			if(visited[node] != true) {
				dfs(node);
			}
		}
	}
	
	// bfs 함수
	public static void bfs(int root) {
		Queue<Integer> queue = new LinkedList<>();
		visited[root] = true;
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			
			for(int node : tree[current]) {
				if(!visited[node]) {
					visited[node] = true;
					queue.offer(node);
				}
			}
		}
		
	}
	
}
