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
			boolean[] arr1Visited = new boolean[100];
			boolean[] arr2Visited = new boolean[100];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				int index = Integer.parseInt(st.nextToken());
				int node = Integer.parseInt(st.nextToken());
				
				if (arr1[index] == 0) {
					arr1[index] = node;
				} else {
					arr2[index] = node;
				}
			}
			
			Deque<Integer> stack = new ArrayDeque<>();
			stack.push(arr1[0]);
			arr1Visited[0] = true;
			boolean flag = true;
			
			while (flag) {
				int top = stack.peek();
				
				// 길이 있다면
				if (arr1[top] == 99 || arr2[top] == 99) {
					break;
				}
				
				// 길을 찾지 못했을 때 종료 (이미 방문했던 곳이라면)
				if (arr1Visited[top] == true && arr2Visited[top] == true) {
					flag = false;
					break;
				}
		
				// 첫번째 배열의 노드에 방문하지 않았다면
				if (arr1[top] != 0 && arr1Visited[top] == false) {
					stack.push(arr1[top]);  // 스택에 추가
					arr1Visited[top] = true;  // 방문 기록
				} 
				
				// 두번째 배열의 노드에 방문하지 않았다면
				else if (arr2[top] != 0 && arr2Visited[top] == false){
					stack.push(arr2[top]);  // 스택에 추가
					arr2Visited[top] = true;  // 방문 기록
				} 

				// 해당 노드에 배열이 비어있다면
				else if (arr1[top] == 0 || arr2[top] == 0) {
					stack.pop();  // 방문할 수 없는 곳이니 pop 
					arr1Visited[top] = true;  // 방문 기록
					arr2Visited[top] = true;  // 방문 기록
				}	
			}
			
			if (flag) {
				sb.append("#").append(tc).append(" ").append(1).append("\n");
			} else {
				sb.append("#").append(tc).append(" ").append(0).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}