import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			pq.offer((long) Integer.parseInt(st.nextToken()));
		}
		
		for (int i=0; i<M; i++) {
			long a = pq.poll();
			long b = pq.poll();
			
			long temp = a + b;
			pq.offer(temp);
			pq.offer(temp);
			
		}
		
		long sum = 0;
		for (int i=0; i<N; i++) {
			long num = pq.poll();
			
			sum += num;
		}

		System.out.println(sum);
	}

}
