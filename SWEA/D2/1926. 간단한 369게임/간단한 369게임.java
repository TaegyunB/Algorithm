import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        for(int i=1; i<=N; i++){
			// 문자열로 변환
            String num = Integer.toString(i);
            int count = 0;
            
            // 각 자리수에서 3, 6, 9가 몇번 나오는지 계산
            for(int j=0; j<num.length(); j++){
             	char digit = num.charAt(j);
                if(digit == '3' || digit == '6' || digit == '9'){
                 	count++;
                }
            }
            
            // 3, 6, 9가 있으면 개수만큼 "-" 출력
            if(count > 0){
                for(int j=0; j<count; j++){
                 	System.out.print("-");   
                }
                System.out.print(" ");
            }
			else {
				System.out.print(i + " ");
            }
		}
    }
}