import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
	
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			int absA = Math.abs(a);
			int absB = Math.abs(b);
			
			if (absA == absB) {  // 절대값이 같으면
				return a - b;  // 작은 값부터 출력
			}
			
			return absA - absB;  // 절대값 작은 것 부터
		});
		
		for (int i=0; i<N; i++)	{
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					int num = pq.poll();
					sb.append(num).append("\n");					
				}
				
			} else {
				pq.offer(x);
			}
		}
		
		System.out.println(sb);
	}
}
