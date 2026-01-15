import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String infix = br.readLine();
			
			// 1단계: 중위 표기식 -> 후위 표기식으로 변환
			// "3+4+5" -> "34+5+"
			String postfix = infixToPostfix(infix);
			
			// 2단계: 후위 표기식 계산
			// "34+5+" -> 12
			int answer = calculatePostfix(postfix);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}
	
	/**
	 * 중위 표기식을 후위 표기식으로 변환
	 */
	static String infixToPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();  // 결과 문자열
		Deque<Character> stack = new ArrayDeque<>();
		
		for (int i=0; i<infix.length(); i++) {

			// 현재 문자가 숫자인 경우
			if (infix.charAt(i) != '+') {
				// 숫자는 즉시 결과 문자열에 추가
				postfix.append(infix.charAt(i));
			} 
			// 현재 문자가 연산자(+)인 경우
			else if (infix.charAt(i) == '+') {
				// 스택에 있던 모든 연산자를 먼저 결과에 추가
				// (같은 우선순위의 연산자는 왼쪽부터 계산하기 위함)
				while (!stack.isEmpty()) {
					postfix.append(stack.pop());
				}
				
				// 현재 연산자를 스택에 push
				// (다음에 올 숫자들을 기다림)
				stack.push(infix.charAt(i));
			}
		}
		
		// 입력이 끝난 후 스택에 남아있는 모든 연산자를 결과에 추가
		// (마지막 연산자 처리)
		while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
	
		// 완성된 후위 표기식 반환
		return postfix.toString();
	}
	
	/**
	 * 후위 표기식 값 구하기
	 */
	static int calculatePostfix(String postfix) {
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i=0; i<postfix.length(); i++) {
			// 현재 문자가 숫자인 경우
			if (postfix.charAt(i) != '+') {
				// char를 int로 변환하여 스택에 push
				int num = Integer.parseInt(String.valueOf(postfix.charAt(i)));
				stack.push(num);
			} 

			// 현재 문자가 연산자(+)인 경우 
			else {
				// 스택에서 두 개의 숫자를 꺼냄
				int x = stack.pop();  // 두 번째 피연산자 (나중에 들어간 것)
				int y = stack.pop();  // 첫 번째 피연산자 (먼저 들어간 것)
				stack.push(x+y);  // 두 숫자를 더한 결과를 다시 스택에 push
			}
		}
		
		return stack.pop();
	}
}