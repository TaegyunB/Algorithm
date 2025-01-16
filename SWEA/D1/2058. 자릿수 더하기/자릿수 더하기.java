import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String n_str = Integer.toString(n); // 정수를 문자열로 변환
        int sum = 0;
        
        for(int i=0; i<n_str.length(); i++){
         	int index_num = n_str.charAt(i) - '0'; // ASCII 코드를 활용하여 정수로 변환
            sum += index_num;
        }
        
        System.out.println(sum);
	}
}