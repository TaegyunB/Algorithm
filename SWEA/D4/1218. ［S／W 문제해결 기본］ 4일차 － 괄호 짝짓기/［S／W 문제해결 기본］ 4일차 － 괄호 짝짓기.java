import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
//		Map.of() 는 OpenJDK8에서 지원 안함. 9부터 지원
//		Map<Character, Character> closeToOpen = Map.of(')', '(', ']', '[', '}', '{', '>', '<');
		Map<Character, Character> closeToOpen = new HashMap<Character, Character>() {{
			put(')', '(');
			put(']', '[');
			put('}', '{');
			put('>', '<');
			}};
		
		for (int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			Deque<Character> stack = new ArrayDeque();
			
			// (), [], {}, <>
			
			stack.push(input.charAt(0));  // 첫 번째는 바로에 Stack에 추가
			
			for (int i=1; i<input.length(); i++) {  // 두 번째부터 시작
				Character newChar = input.charAt(i);
				Character stackPeek = stack.peek();
				
				if (newChar == ')' || newChar == ']' || newChar == '}' || newChar == '>') {  // 만약 newChar이 닫히는 괄호라면
					if (stackPeek.equals(closeToOpen.get(newChar))) {  // 만약에 newChar의 value 값이 stack 마지막 값이랑 같다면
						stack.pop();  // 제거
					} else {  // 만약에 newChar의 value 값이 stack 마지막 값이랑 다르다면
						stack.push(newChar);  // 추가
					}
				} else {  // 만약 newChar이 열리는 괄호라면
					stack.push(newChar);  // 추가
				}
			}
			
			sb.append("#").append(tc).append(" ");
			if (stack.isEmpty()) {  // stack이 비어있다면 (유효함)
				sb.append(1);
			} else {  // stack이 비어있지 않다면 (유효하지 않음)
				sb.append(0);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}