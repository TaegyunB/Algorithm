import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
    	
        int T = sc.nextInt();
        
        for(int i=0; i<T; i++) {
            int[] num_list = new int[10];
        	int odd = 0;
            
            for(int j=0; j<10; j++) {
             	num_list[j] = sc.nextInt();
            }
            
            for(int j=0; j<10; j++){
            	if(num_list[j] % 2 != 0) {
                 	   odd += num_list[j];
                }
            }
            System.out.println("#" + (i+1) + " " + odd);
        }
	}
}