import java.io.*;
import java.util.*;

public class Main {

	// 각 원소의 부모를 저장하는 배열
	// parent[x] = x 의 부모 노드
	static int[] parent;
	
	// 트리의 높이를 관리 (Union By Rank 최적화용)
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		rank = new int[N+1];
		
		// 초기 상태: 모든 원소는 자기 자신이 부모
		for (int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (com == 0) {
				union(a, b);
			} else if (com == 1) {
				int findA = find(a);
				int findB = find(b);
				
				if (findA == findB) {
					sb.append("YES \n");
				} else {
					sb.append("NO \n");
				}
			}
		}
		
		System.out.println(sb);
	}

	// find 함수: x가 속한 집합의 "대표(루트)"를 찾는다
	static int find(int x) {
		
		// 자기 자신이 부모라면 루트 노드
		if (parent[x] == x) {
			return x;
		}
		
		// 경로 압축
		// 부모를 재귀적으로 찾아가면서
		// 최종 루트를 바로 부모로 설정
		// -> 다음 find가 매우 빨라짐
		return parent[x] = find(parent[x]);
	}
	
	// union 함수: a와 b가 속한 집합을 합친다
	static void union(int a, int b) {

		// 각 원소의 루트를 찾음
		a = find(a);
		b = find(b);
		
		// 이미 같은 집합이라면 합칠 필요 없음
		if (a == b) {
			return;
		}
		
		// Union By Rank (트리 높이 최소화)
		if (rank[a] < rank[b]) {
			parent[a] = b;  // a 트리를 b 밑으로
		} else if (rank[a] > rank[b]) {
			parent[b] = a;  // b 트리를 a 밑으로
		} else {
			// 높이가 같다면 아무거나 붙임
			parent[b] = a;
			rank[a]++;  // 트리 높이 증가
		}
	}

}
