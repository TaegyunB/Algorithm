import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int i=0; i<T; i++) {
        	int a = sc.nextInt();
            int b = sc.nextInt();
            
            int portion = a / b;
            int remain = a % b;
            
            System.out.println("#" + (i+1) + " " + portion + " " + remain);
        }
	}
}