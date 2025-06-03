import java.util.Scanner;

public class Main {
	
	static String[] vowels = {"a", "e", "i", "o", "u"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag) {
			/*
			 sc.next() -> 공백 단위로 읽음
			 sc.nextLine() -> 한 줄 전체를 읽음
			 */
			String input = sc.nextLine();
			int count = 0;
			
			if(input.equals("#")) {
				flag = false;
				break;
			}
			
			for(char letter : input.toLowerCase().toCharArray()) {
				for(String v : vowels) {
					if(letter == v.charAt(0)) {
						count++;
					}
				}
			}
			System.out.printf("%d\n", count);
		}
	}
}
