import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;
	static int[] rank;  // 트리 높이 저장 (Union By Rank 최적화)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N];
		rank = new int[N];
		
		// 부모 배열 초기화
		for (int i=0; i<N; i++) {
			parent[i] = i;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 두 노드를 union하면서 사이클 여부 확인
			boolean isCycle = union(start, end);
			
			// 사이클 발생하는 순간 게임 종료
			if (isCycle) {
				System.out.println(i+1);
				return;
			}
		}
		
		System.out.println(0);
	}
	
	// 특정 노드가 속한 집합의 대표(root)를 찾는 함수
	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		
		// path compression
		return parent[x] = find(parent[x]);
	}
	
	// 두 집합을 합치는 union 연산
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		// 이미 같은 집합이면
		// 두 노드를 연결하면 사이클이 생성됨
		if (a == b) {
			return true;
		}
		
		// Union By Rank
		// 높이가 작은 트리를 큰 트리 밑으로 붙임
		if (rank[a] > rank[b]) {
			parent[b] = a;
		} else if (rank[a] < rank[b]) {
			parent[a] = b;
		} else {
			// 높이가 같으면 한쪽을 부모로 하고
			// 트리 높이(rank)를 1 증가
			parent[b] = a;
			rank[a]++;
		}
		
		// 정상적으로 합쳐졌고 사이클은 없음
		return false; 
	}
}
