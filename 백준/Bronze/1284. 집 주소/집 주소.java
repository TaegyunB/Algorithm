import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		
		while(flag) {
			String input = sc.nextLine();
			
			if(Integer.parseInt(input) == 0) {  // 문자열을 정수로 변환
				flag = false;
				break;
			}
			
			int w_length = 2;
			
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) == '1') {  // char는 '' 로 표현
					w_length += 2;
				}
				else if(input.charAt(i) == '0') {
					w_length += 4;
				}
				else {
					w_length += 3;
				}
			}
			
			w_length += input.length() - 1;
			
			System.out.println(w_length);
		}
	}
}
