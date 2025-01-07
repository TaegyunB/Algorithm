import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
        
        for(int i=0; i<T; i++) {
         	String word = sc.next();
			int mid = word.length() / 2;
            boolean result = true;
            
            // 팰린드롬 검사
            for(int j=0; j<mid; j++) {
                int len = word.length();
             	if (word.charAt(j) == word.charAt(len - j - 1)) {
                 	continue;   
                }
                else {
                    result = false;
                    break;
                }
            }
            if (result) {
             	System.out.println("#" + (i+1) + " " + 1);   
            }
            else {
             	System.out.println("#" + (i+1) + " " + 0);   
            }
        }
	}
}