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
			
			// 명령어 줄 전체를 공백 기준으로 split하여 배열에 저장 
			String[] input = br.readLine().split(" ");
			
			// 명령어 배열을 순회하며 처리
			for (int i=0; i<input.length; i++) {
				// "I" (Insert) 명령어 발견
				// 형식: I x y s1 s2 ... sy
				// x 위치에 y개의 숫자(s1, s2, ..., sy)를 삽입
				if (input[i].equals("I")) {
					int posIndex = i+1;  // 삽입할 위치 값 인덱스
					int commandLengthIndex = i+2;  // 삽입할 숫자의 개수 인덱스
					int needToAddIndex = i+3;  // s1의 시작 인덱스
					
					// y개의 숫자를 리스트에 삽입
					for (int j=0; j<Integer.parseInt(input[commandLengthIndex]); j++) {
						// x+j 위치에 숫자 삽입
						// 예: x=3이고 2개 삽입 -> 3번 위치, 4번 위치에 삽입
						list.add(Integer.parseInt(input[posIndex])+j, input[needToAddIndex+j]);
					}
					
					// i를 다음 명령어 시작 위치로 이동
					// +2는 x와 y를 건너뛰기 위함
					// +commandLength는 삽입한 숫자들을 건너뛰기 위함
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