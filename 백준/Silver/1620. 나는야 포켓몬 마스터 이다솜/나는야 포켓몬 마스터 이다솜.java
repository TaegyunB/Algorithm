import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> nameToNum = new HashMap<>();
		Map<Integer, String> numToName = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			String pokemon = br.readLine();
			nameToNum.put(pokemon, i+1);
			numToName.put(i+1, pokemon);
		}
		
		for (int i=0; i<M; i++) {
			String question = br.readLine();
			if (nameToNum.containsKey(question)) {
				sb.append(nameToNum.get(question)).append("\n");
			} else {
				int index = Integer.parseInt(question);
				sb.append(numToName.get(index)).append("\n");

			}
		}
		
		System.out.println(sb);
	}

}
