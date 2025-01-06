import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
        int T = sc.nextInt();
        
        for(int i=0; i<T; i++){
         	int A = sc.nextInt();
            int B = sc.nextInt();
            int N = sc.nextInt();
            int count = 0;
            
            while(A <= N && B <= N){ // A와 B 모두가 N 이하이어야 하기 때문에 && 사용
               	if(A > B) {
             		B += A;   
            	}
            	else {
             		A += B;   
            	}
                count++;
            }
            System.out.println(count);
        }
	}
}