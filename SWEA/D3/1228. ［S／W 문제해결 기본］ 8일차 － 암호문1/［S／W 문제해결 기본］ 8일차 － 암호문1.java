import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i=0; i<N; i++) {
				list.add(st.nextToken());
			}
			
			int commandNum = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			
			for (int i=0; i<input.length; i++) {
				if (input[i].equals("I")) {
					int posIndex = i+1;
					int commandLengthIndex = i+2;
					int needToAddIndex = i+3;
					
					for (int j=0; j<Integer.parseInt(input[commandLengthIndex]); j++) {
						list.add(Integer.parseInt(input[posIndex])+j, input[needToAddIndex+j]);
					}
					
					i += Integer.parseInt(input[commandLengthIndex])+2;
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for (int i=0; i<10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}