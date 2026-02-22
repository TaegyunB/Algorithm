import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> tunnerIn = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			String car = br.readLine();
			tunnerIn.put(car, i);
		}
		
		int[] tunnerOut = new int[N];
		for (int i=0; i<N; i++) {
			String car = br.readLine();
			tunnerOut[i] = tunnerIn.get(car);
		}
		
		int cnt = 0;
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				if (tunnerOut[i] > tunnerOut[j]) {  // tunnerOut[i] 보다 뒤에 더 작은 값이 있다면 추월했다고 판정
					cnt++;
					break;
				}
			}
		}
	
		System.out.println(cnt);
	}

}
