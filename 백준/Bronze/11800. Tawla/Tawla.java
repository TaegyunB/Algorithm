import java.util.Scanner;

public class Main {
	
	static String[] alias = {"", "Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh"};
	static String[] sameAlias = {"", "Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			
			int max_num = Math.max(c1, c2);
			int min_num = Math.min(c1, c2);
			
			if (max_num == min_num) {
				System.out.printf("Case %d: %s\n", tc, sameAlias[max_num]);
			} else if (max_num == 6 && min_num == 5) {
				System.out.printf("Case %d: Sheesh Beesh\n", tc);
			} else {
				System.out.printf("Case %d: %s %s\n", tc, alias[max_num], alias[min_num]);
			}
		}
	}
}

