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
		String[] numToName = new String[N];  // 배열을 사용하여 인덱스로 접근
		
		for (int i=0; i<N; i++) {
			String pokemon = br.readLine();
			map.put(pokemon, i+1);
			numToName[i] = pokemon;
		}
		
		for (int i=0; i<M; i++) {
			String question = br.readLine();
			if (map.containsKey(question)) {
				sb.append(map.get(question)).append("\n");
			} else {
				int index = Integer.parseInt(question);
				sb.append(numToName[index-1]).append("\n");

			}
		}
		
		System.out.println(sb);
	}

}
