import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[100];
			
			for (int i=0; i<100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);  // 오름차순
			
			for (int i=0; i<N; i++) {
				// 평탄화를 맞추기 위해
				arr[0] += 1;  // 제일 낮은 값에 더하고
				arr[99] -= 1;  // 제일 큰 값에서 뺴기
				
				Arrays.sort(arr);  // 다시 정렬
			}
			
			int result = arr[99] - arr[0];  // 제일 큰 값이랑 제일 낮은 값을 구하기
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
}