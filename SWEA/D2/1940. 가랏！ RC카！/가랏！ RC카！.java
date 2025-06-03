import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			int distance = 0;
			int speed = 0;
			
			for(int n=0; n<N; n++) {
				int c1 = sc.nextInt();
				
				if(c1 == 1) {
					int c2 = sc.nextInt();
					speed += c2;
				}
				else if(c1 == 2) {
					int c2 = sc.nextInt();
					speed -= c2;
					
					if(speed < 0) {
						speed = 0;
					}
				}
				
				distance += speed;
			}
			
			System.out.printf("#%d %d\n", tc, distance);
		}
	}

}
