import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int[] num_list = new int[10];
        
        for(int i=0; i<T; i++) {
            int sum = 0;
            
            for(int j=0; j<10; j++) {
                num_list[j] = sc.nextInt();
                sum += num_list[j];
            }
            
            double avg = (double) sum / 10;
            avg = Math.round(avg); // 반올림
         	System.out.println("#" + (i+1) + " " + (int) avg);  
        }
	}
}