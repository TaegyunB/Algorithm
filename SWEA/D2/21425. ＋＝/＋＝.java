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
            int n = sc.nextInt();
            int count = 0;
            
            while(a <= n && b <= n) {
                if(a > b) {
                 	b += a;   
                }
                else {
                 	a += b;   
                }
                count++;
            }
            System.out.println(count);
        }
	}
}