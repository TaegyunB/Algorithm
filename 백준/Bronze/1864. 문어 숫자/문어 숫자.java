import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		
		while(flag) {
			String input = sc.nextLine();
			
			if(input.equals("#")) {
				flag = false;
				break;
			}
			
			int num = 0;
			int sum = 0;
			int i_length = input.length()-1;
			
			for(char letter : input.toCharArray()) {
				if(letter == '-') {
					num = 0;
					sum += num * Math.pow(8, i_length);  // 자바 제곱 -> Math.pow(숫자, 제곱할 값)
					i_length--;
				}
				else if(letter == '\\') {
					num = 1;
					sum += num * Math.pow(8, i_length);
					i_length--;
				}
				else if(letter == '(') {
					num = 2;
					sum += num * Math.pow(8, i_length);
					i_length--;
				}
				else if(letter == '@') {
					num = 3;
					sum += num * Math.pow(8, i_length);
					i_length--;
				}
				else if(letter == '?') {
					num = 4;
					sum += num * Math.pow(8, i_length);
					i_length--;
				}
				else if(letter == '>') {
					num = 5;
					sum += num * Math.pow(8, i_length);
					i_length--;
				}
				else if(letter == '&') {
					num = 6;
					sum += num * Math.pow(8, i_length);
					i_length--;
				}
				else if(letter == '%') {
					num = 7;
					sum += num * Math.pow(8, i_length);
					i_length--;
				}
				else if(letter == '/') {
					num = -1;
					sum += num * Math.pow(8, i_length);
					i_length--;
				}
			}
			System.out.println(sum);
		}
	}
}
