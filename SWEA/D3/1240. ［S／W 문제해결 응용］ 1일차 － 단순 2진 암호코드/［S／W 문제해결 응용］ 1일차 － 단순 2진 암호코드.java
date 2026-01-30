import java.io.*;
import java.util.*;

public class Solution {
	
	static Map<String, Integer> codes = new HashMap<String, Integer>(){
		{
			put("0001101", 0);
			put("0011001", 1);
			put("0010011", 2);
			put("0111101", 3);
			put("0100011", 4);
			put("0110001", 5);
			put("0101111", 6);
			put("0111011", 7);
			put("0110111", 8);
			put("0001011", 9);
		}
	};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][] arr = new char[N][M];
			List<Integer> answerList = new ArrayList<>();
			
			for (int x=0; x<N; x++) {
				String input = br.readLine();
				
				for (int y=0; y<M; y++) {
					arr[x][y] = input.charAt(y);
				}
			}
			
			// 뒤에서부터
			for (int x=0; x<N; x++) {
				boolean found = false;
				
				for (int y=M-1; y>=0; y--) {
					if (found) {
						break;
					}
					
					if (arr[x][y] == '1') {  // 뒤에서부터 1을 찾으면 - 모든 암호는 1로 끝나기 때문에
						found = true;
						
						for (int i=y; i>y-56; i--) {  // y-56가 마지막 위치 다음 위치를 의미 (여기까지 순회하라)
							StringBuilder oppositeCode = new StringBuilder();
							
							
							int ii = i;
							// 암호가 7자리니깐 7자리를 oppositeCode에 추가
							for (int j=0; j<7; j++) {
								oppositeCode.append(arr[x][ii]);
								ii--;
							}
							
							// 뒤에서 부터 넣었으니깐 순서를 바꿔줘야함
							String reverse = oppositeCode.reverse().toString();
							
							// code의 key값을 순회하면서
							for (String code : codes.keySet()) {
								boolean founded = false;
								
								if (reverse.equals(code)) {  // reverse랑 code의 key값이 같다면
									answerList.add(codes.get(code));  // value값을 answerList에 추가
									founded = true;
								}
								
								if (founded) {
									break;
								}
							}
							
							i -= 6;
						}
					}
				}
				
				if (found) {
					break;
				}
			}
			
			// 답도 뒤에서부터 들어갔으니깐 순서를 바꿔줘야함
			Collections.reverse(answerList);
			
			int even = 0;
			int odd = 0;
			
			for (int i=0; i<8; i++) {
				if (i % 2 == 0) {
					even += answerList.get(i);
				}
				else {
					odd += answerList.get(i);
				}
			}
			
			int answer = (even * 3) + odd;
			
			if (answer % 10 == 0) {
				answer = odd + even;
				sb.append("#").append(tc).append(" ").append(answer).append("\n");
			}
			else {
				sb.append("#").append(tc).append(" ").append(0).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}