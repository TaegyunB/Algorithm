import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        int answer = 1;
        
        for(int i=1; i<=num+1; i++) {
            if(i == 1) {
            	System.out.print(1 + " ");   
            }
            else {
                answer *= 2;
             	System.out.print(answer + " ");
            }
         	
        }
	}
}