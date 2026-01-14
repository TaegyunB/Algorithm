import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String password = st.nextToken();
			
			Deque<Character> stack = new ArrayDeque<>();  // Stack 선언
			
			for (int i=0; i<password.length(); i++) {
				
				if (stack.isEmpty() || !stack.peek().equals(password.charAt(i))) {  // Stack이 비어있거나 Stack의 마지막 요소와 Stack에 추가할 요소랑 같지 않다면
					stack.push(password.charAt(i));  // 아니면 추가					
				}
				else if (stack.peek().equals(password.charAt(i))) {  // Stack의 마지막 요소가 Stack에 추가할 요소랑 같다면
					stack.pop();  // Stack의 마지막 요소 제거
				}
			}
			
			sb.append("#").append(tc).append(" ");
			
			// List 선언해서 stack.pop() 한 값을 추가
			List<Character> list = new ArrayList<>();  
			int stackSize = stack.size();
			for (int i=0; i<stackSize; i++) {
				list.add(stack.pop());
			}
			
			// 순서가 거꾸로 되어있기 때문에 거꾸로 다시 바꾸기 위함
			for (int i=list.size()-1; i>=0; i--) {
				sb.append(list.get(i));
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}