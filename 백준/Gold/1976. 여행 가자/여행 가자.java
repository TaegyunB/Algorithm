import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];  // parent 배열 초기화

		// 처음에는 모든 도시가 서로 다른 집합 (자기 사진이 대표)
		for (int i=0; i<=N; i++) {
			parent[i] = i;
		}
		
		// i번 도시와 j번 도시가 연결되어 있으면 1, 아니면 0
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j=1; j<=N; j++) {
				
				// i와 j가 직접 연결되어 있다면
				if (Integer.parseInt(st.nextToken()) == 1) {
					union(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int firstCity = Integer.parseInt(st.nextToken());  // 여행 첫 도시
		int root = find(firstCity);  // 첫 도시가 속한 곳 탐색
		
		// 나머지 도시들이 모두 같은 집합인지 확인
		for (int i=1; i<M; i++) {
			int city = Integer.parseInt(st.nextToken());
			
			// 하나라도 다른 집합이면 여행 불가능
			if (find(city) != root) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}

	// find 함수: x가 속한 집합의 대표(루트) 찾기
	public static int find(int x) {
		
		// 자기 자신이 부모면 루트
		if (parent[x] == x) {
			return x;
		}
		
		// 경로 압축(Path Compression)
		// 루트를 찾으면서 부모를 바로 루트로 바꿔줌 -> 시간 단축
		return parent[x] = find(parent[x]);
	}
	
	// union 함수: a와 b가 속한 집합을 합치기
	public static void union(int a, int b) {
		
		// 각 원소의 루트를 찾음
		a = find(a);
		b = find(b);
		
		// 이미 같은 집합이면 아무 것도 하지 않음
		if (a == b) {
			return;

		// b의 집합을 a의 집합 밑으로 붙임
		} else {
			parent[b] = a;
		}
	}
}