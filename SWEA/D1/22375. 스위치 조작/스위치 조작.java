import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] start = new int[N];
			int[] answer = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 전등 초기 상태 배열
			for (int i=0; i<N; i++) {
				start[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			// 스위치 조작 후 전등 상태 배열
			for (int i=0; i<N; i++) {
				answer[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;  // 조작 수
			for (int i=0; i<N; i++) {
				if (start[i] != answer[i]) {  // 현재 위치의 전등 상태가 조작 후 전등 상태랑 다르다면
					int ni = i;  // 현재 위치는 다른 변수에 저장
					cnt++;  // 조작 수 증가
					
					while (ni < N) {  // 하나의 전등을 바꾸면 그 뒤에 있는 전등도 바꿔야하기 때문에 마지막까지 전등을 바꾸기
						if (start[ni] == 1) {
							start[ni] = 0;
						} else if (start[ni] == 0) {
							start[ni] = 1;
						}
						ni++;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}