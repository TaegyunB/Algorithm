import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] students = new int[31];
		
		for(int i=1; i<29; i++) {
			int student_num = sc.nextInt();
			
			students[student_num] = 1; 
		}
		
		for(int i=1; i<31; i++) {
			if(students[i] != 1) {
				System.out.println(i);
			}
		}
		
	}		
}
