import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 StringTokenizer st;
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 for (int i=0; i<T; i++) {
			 int K = Integer.parseInt(br.readLine());
			 
			 Queue<Integer> min = new PriorityQueue<>();
			 Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
			 Map<Integer, Integer> map = new HashMap<>();
			 
			 for (int j=0; j<K; j++) {
				 st = new StringTokenizer(br.readLine());
				 String command = st.nextToken();
				 int num = Integer.parseInt(st.nextToken());
				 
				 if (command.equals("I")) {
					 min.offer(num);
					 max.offer(num);
					 map.put(num, map.getOrDefault(num, 0) + 1);
				 } else if (command.equals("D")) {
					 if (num == 1) {
						 clearDeleteNum(max, map);
						 if (max.isEmpty()) {
							 continue;
						 }
						 int delete = max.poll();
						 decCnt(map, delete);
					 } else  if (num == -1) {
						 clearDeleteNum(min, map);
						 if (min.isEmpty()) {
							 continue;
						 }
						 int delete = min.poll();
						 decCnt(map, delete);
					 }
				 }
			 }
			 
			 clearDeleteNum(max, map);
			 clearDeleteNum(min, map);
			 
			 if (map.isEmpty()) {
				 sb.append("EMPTY \n");
			 } else {
				 sb.append(max.peek()).append(" ").append(min.peek()).append("\n");	  
			 }
		 }
		 
		 System.out.println(sb);
	}
	
	static void clearDeleteNum(Queue<Integer> q, Map<Integer, Integer> map) {
		while (!q.isEmpty()) {
			int x = q.peek();
			Integer num = map.get(x);
			
			if (num == null || num == 0) {
				q.poll();
			} else {
				break;
			}
		}
	}
	
	static void decCnt(Map<Integer, Integer> map, int x) {
		int num = map.getOrDefault(x, 0);
		
		if (num <= 1) {
			map.remove(x);
		} else {
			map.put(x, num-1);
		}
		
		
	}
}
