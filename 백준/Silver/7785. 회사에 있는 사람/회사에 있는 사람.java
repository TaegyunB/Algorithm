import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Map<String, String> enter = new TreeMap<>(Collections.reverseOrder());  // TreeMap을 사용하면 자동으로 키 기준으로 정렬
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			String isWork = st.nextToken();
			
			if (isWork.equals("enter")) {
				enter.put(name, isWork);
			} else {
				enter.remove(name);
			}
		}
	
		for (String name : enter.keySet()) {
			sb.append(name).append("\n");
		}

		System.out.println(sb);
	}

}
