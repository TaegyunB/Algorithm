import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int i=0; i<T; i++) {
         	Integer[] num_list = new Integer[10];
            
            for(int j=0; j<10; j++) {
             	num_list[j] = sc.nextInt();
            }
            
            Arrays.sort(num_list, Collections.reverseOrder());
            System.out.println("#" + (i+1) + " " + num_list[0]);
        }
	}
}