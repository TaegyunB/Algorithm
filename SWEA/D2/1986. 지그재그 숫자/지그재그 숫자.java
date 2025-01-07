import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
         	int n = sc.nextInt();
            int sum = 0;
            
            for (int j=1; j<=n; j++) {
                if (j % 2 != 0) {
                 	   sum += j;
                }
                else {
                    sum -= j;
                }
            }
            System.out.println("#" + (i+1) + " " + sum);
        }
	}
}