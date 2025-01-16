import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int i=0; i<T; i++) {
         	int num_1 = sc.nextInt();
            int num_2 = sc.nextInt();
            String result = "";
            
            if(num_1 < num_2) {
            	result += "<";
            }
            else if(num_1 > num_2) {
             	result += ">";   
            }
            else {
             	result += "=";   
            }
            System.out.println("#" + (i+1) + " " + result);
        }
	}
}