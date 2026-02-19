import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for (int i=0; i<N+M; i++) {
			String input = br.readLine();
			
			map.put(input, map.getOrDefault(input, 0) + 1);
		}
		
		int cnt = 0;
		List<String> answer = new ArrayList<>();
		for (String name : map.keySet()) {
			if (map.get(name) >= 2) {
				cnt++;
				answer.add(name);
			}
		}
		
		Collections.sort(answer);
		
		sb.append(cnt).append("\n");
		for (String name : answer) {
			sb.append(name).append("\n");
		}
		
		System.out.println(sb);
	}

}
