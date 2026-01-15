import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			Deque<Integer> stackNum = new ArrayDeque<>();
			Deque<Character> stackSymbol = new ArrayDeque<>();
			
			for (int i=0; i<N; i++) {
				if (input.charAt(i) != '+') {
					stackNum.push(Integer.parseInt(String.valueOf(input.charAt(i))));
				} else {
					stackSymbol.push(input.charAt(i));
				}
			}
			
			int a = stackNum.pop();
			int b = stackNum.pop();
			int c = stackSymbol.pop();
			
			int sum = 0;
			if (c == '+') {
				sum = a + b;
			}
			
			while (!stackSymbol.isEmpty()) {
				int num =stackNum.pop();
				int symbol = stackSymbol.pop();
				if (symbol == '+') {
					sum += num;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}