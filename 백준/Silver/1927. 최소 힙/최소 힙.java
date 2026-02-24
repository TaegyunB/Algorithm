import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();  // 최소힙
		
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					int minNum = pq.poll();
					sb.append(minNum).append("\n");	
				}
			} else {
				pq.offer(x);
			}
		}
		
		System.out.println(sb);
	}
}
