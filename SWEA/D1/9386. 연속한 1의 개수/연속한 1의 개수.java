import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	

	public static void main(String[] args) throws IOException{
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			int max_count = 0;
			int count = 0;
			for(int i=0; i<input.length(); i++) {
				int num = input.charAt(i) - '0';  // char형 숫자를 실제 숫자로 바꾸는 고전적인 방법
				
				if(num == 1) {
					count++;
					
					if(count > max_count) {
						max_count = count;
					}
				} else {
					count = 0;
				}
				
			}
			
			System.out.printf("#%d %d\n", tc, max_count);
		}
	}
}
