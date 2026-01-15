import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tcNum = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int[] arr1 = new int[100];
			int[] arr2 = new int[100];
			boolean[] visited = new boolean[100];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				int index = Integer.parseInt(st.nextToken());  // 출발 노드
				int node = Integer.parseInt(st.nextToken());  // 도착 노드
				
				// 첫 번째 갈림길이 비어있으면 arr1에 저장
				if (arr1[index] == 0) {
					arr1[index] = node;
				} else {  // 이미 arr1에 값이 있으면 arr2에 저장 (두 번째 갈림길)
					arr2[index] = node;
				}
			}
			
			// DFS(깊이 우선 탐색)를 위한 스택 생성
			Deque<Integer> stack = new ArrayDeque<>();
			stack.push(0);  // 시적잠 0번 노드를 스택에 추가
			visited[0] = true;  // 0번 노드 방문 처리
			
			boolean found = false;
			
			// 스택이 빌 때까지 탐색 (모든 경로 탐색)
			while (!stack.isEmpty()) {
				int now = stack.pop();
				
				// 목적지까지 길이 있다면 탐색 종료
				if (now == 99) {
					found = true;
					break;
				}
		
				// 현재 노드에서 갈 수 있는 첫 번째 경로 확인
				// arr1[now]에 노드가 있고(!=0), 아직 방문하지 않았다면(!visited)
				if (arr1[now] != 0 && !visited[arr1[now]]) {
					stack.push(arr1[now]);  // 다음 탐색을 위해 스택에 추가
					visited[arr1[now]] = true;  // 방문 기록
				} 
				
				// 현재 노드에서 갈 수 있는 두 번째 경로 확인
				// arr2[now]에 노드가 있고(!=0), 아직 방문하지 않았다면(!visited)
				if (arr2[now] != 0 && !visited[arr2[now]]){
					stack.push(arr2[now]);  // 다음 탐색을 위해 스택에 추가
					visited[arr2[now]] = true;  // 방문 기록
				} 	
			}
			
			if (found) {
				sb.append("#").append(tcNum).append(" ").append(1).append("\n");
			} else {
				sb.append("#").append(tcNum).append(" ").append(0).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}