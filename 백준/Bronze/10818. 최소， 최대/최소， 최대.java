import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max_num = -1000000;
		int min_num = 1000000;
		
		for(int i=0; i<N; i++) {
			if(arr[i] >= max_num) {
				max_num = arr[i];
			}
			if(arr[i] <= min_num) {
				min_num = arr[i];
			}
		}
		
		System.out.println(min_num + " " + max_num);
		
	}
}
