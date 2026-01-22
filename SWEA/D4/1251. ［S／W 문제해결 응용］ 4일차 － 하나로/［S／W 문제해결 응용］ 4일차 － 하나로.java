import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] xArr = new int[N];  // 각 섬의 x 좌표 저장 배열
			int[] yArr = new int[N];  // 각 섬의 y 좌표 저장 배열
			
			// 모든 섬의 x 좌표 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				xArr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 모든 섬의 y 좌표 입력
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				yArr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 환경 부담 세율 E 입력
			double E = Double.parseDouble(br.readLine());
			
			// 간선을 비용 기준 오름차순으로 정렬하기 위한 우선순위 큐
			PriorityQueue<Pos> pq = new PriorityQueue<>();
			
			// 모든 섬 간의 간선(연결) 생성
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (i == j) {  // 간선이 없는 거
						continue;
					}
					
					// 두 섬 사이의 거리 계산: (x1-x2)^2 + (y1-y2)^2
					double distance = Math.pow(xArr[i] - xArr[j], 2) +  Math.pow(yArr[i] - yArr[j], 2);
					pq.add(new Pos(i, j, distance * E));  // pq에 추가
				}
			}
			
			// Union-Find를 위한 부모 배열 생성
			parents = new int[N+1];
			
			// 부모 배열 초기화: 처음에는 자기 자신이 부모
			for (int i=0; i<N+1; i++) {
				parents[i] = i;
			}
			
			// 크루스칼 알고리즘: MST(최소 신장 트리) 구성
			int cnt = 0;  // 선택한 간선의 개수
			double result = 0; // 총 비용
			
			// N-1개의 간선을 선택할 때까지 반복 (MST는 N-1개의 간선 필요)
			while (!pq.isEmpty() || cnt != N-1) {
				Pos cur = pq.poll();  // 가장 비용이 낮은 간선 꺼내기 
				
				// 두 섬을 연결해도 사이클이 생기지 않으면 (다른 집합이면)
				if(union(cur.x, cur.y)) {
					cnt++;  // 선택한 간선 개수 증가
					result += cur.cost;  // 총 비용에 추가
				}
			}
			
			// 반올림 처리
			result *= 10;  // 소수점 첫째 자리를 정수로
			result = (long) result;  // long으로 변환
			int remain = (int)(result % 10);  // 소수점 첫째 자리 값
			
			// 소수점 첫째 자리가 5 이상이면 올림
			if (remain >= 5) {
				result += 10;
			}
			
			sb.append("#").append(tc).append(" ").append((long) result / 10).append("\n");
		}

		System.out.println(sb);
	}
	
	/**
	 * 간선 정보를 저장하는 클래스 
	 * Comparable을 구현하여 비용 기준 오름차순 정렬
	 */
	static class Pos implements Comparable<Pos> {
		int x;  // 시작 섬
		int y;  // 도착 섬
		double cost;  // 간선 비용
		
		public Pos(int x, int y, double cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		// 비용 기준 오름차순 정렬
		@Override
		public int compareTo(Pos o1) {
			if (cost > o1.cost) {
				return 1;  // 현재 객체가 더 크면 오름차순
			} else if (cost < o1.cost) {
				return -1;  // 현재 객체가 더 작으면 내림차순
			}
			return 0;  // 같으면 순서 유지
		}
	}

	/**
	 * find 함수: 특정 노드가 속한 지합의 루트(대표) 찾기
	 * 경로 압축(Path Compression) 최적화 적용 
	 */
	
	static int find(int node) {
		// 자기 자신이 부모면 루트 노드
		if (parents[node] == node) {
			return node;
		}
		
		/**
		 * 경로 압축: 재귀적으로 루트를 찾으면서 중간 노드들의 부모를 루트로 직접 연결
		 * 이렇게 하면 다음 find 호출 시 O(1)에 찾을 수 있음
		 */
		parents[node] = find(parents[node]);
		return parents[node];
	}
	
	/**
	 * union 함수: 두 노드가 속한 집합을 합치기
	 */
	static boolean union(int node1, int node2) {
		// 각 노드의 루트 찾기
		int root1 = find(node1);
		int root2 = find(node2);
		
		// 이미 같은 집합에 속해 있으면 (사이클 발생)
		if (root1 == root2) {
			return false;  // 합치지 않음
		}
		// 다른 집합이면
		else {
			parents[root1] = root2;  // root1의 부모를 root2로 설정(합치기)
			return true;  // 합쳤음을 반환
		}
	}	
}