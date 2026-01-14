import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			int tcNum = Integer.parseInt(br.readLine());
			String part = br.readLine();
			String input = br.readLine();
			
			int cnt = 0;
			for (int i=0; i<input.length() - part.length() + 1; i++) {
				if (input.charAt(i) == part.charAt(0)) {  // 돌면서 첫 글자가 찾고자 하는 글자의 첫 글자와 같다면
					boolean flag = false;
					
					for (int j=1; j<part.length(); j++) {  // 찾고자 하는 글자만큼 순회하면서
						if (input.charAt(i+j) == part.charAt(j)) {  // 다음 글자가 계속 같다면
							flag = true;
						} else {  // 다음 글자가 계속 틀리다면
							flag = false;
							break;  // for 문 나오기
						}
					}
					
					if (flag) {  // flag가 True라면 (찾고자 하는 문장을 찾았다면)
						cnt++;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}