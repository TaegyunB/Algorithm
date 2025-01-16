import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        String headline = sc.next();
        
        System.out.println(headline.toUpperCase()); // 소문자에서 대문자로 변환
	}
}