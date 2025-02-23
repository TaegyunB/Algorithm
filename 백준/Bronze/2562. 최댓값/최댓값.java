import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		int max_idx = 0;
		
		for(int i=0; i<9; i++) {
			int n = sc.nextInt();
			
			if(n > max) {
				max =n ;
				max_idx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(max_idx+1);
	}		
}
