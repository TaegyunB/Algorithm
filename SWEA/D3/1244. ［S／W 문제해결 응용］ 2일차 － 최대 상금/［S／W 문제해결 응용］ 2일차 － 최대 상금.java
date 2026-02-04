import java.io.*;
import java.util.*;

public class Solution {
	
	static Set<String> visited;  // 중복 계산 방지용
	static int swapCnt;  // 총 교환 횟수
	static int maxValue;  // 찾은 최대값
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			swapCnt = Integer.parseInt(st.nextToken());
			
			maxValue = 0;
			visited = new HashSet<>();
			
			dfs(input, swapCnt, 0);
			
			sb.append("#").append(tc).append(" ").append(maxValue).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(String input, int swapCnt, int cnt) {
		
		String key = input + "_" + cnt;
		if (visited.contains(key)) {  // 이미 이 상태를 이 교환 횟수에서 본 적 있으면
			return;  // 중복 계산 방지를 위해 종료
		}
		
		visited.add(key);  // 현재 상태 방문 표시
		
		// 기저 조건: 정해진 교환 횟수를 다 사용했으면
		if (swapCnt == cnt) { 
			maxValue = Math.max(maxValue, Integer.parseInt(input));
			return;
		 }
		
		// 모든 가능한 쌍에 대해 교환 시도
		for (int i=0; i<input.length(); i++) {
			for (int j=i+1; j<input.length(); j++) {
				String str = swap(input, i, j);  // 교환 실시
				 
				// 교환 후의 상태로 재귀 호출
				dfs(str, swapCnt, cnt+1);
			}
		}
	}
	
	static String swap(String str, int i, int j) {
		char[] arr = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		str = String.valueOf(arr);
		return str;	
	}
}