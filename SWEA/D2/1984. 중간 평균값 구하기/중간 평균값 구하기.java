import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream(&quot;res/input.txt&quot;));

		Scanner sc = new Scanner(System.in);
		
        int T = sc.nextInt();
        
        for(int i=0; i<T; i++){
         	int[] num = new int[10];
            
            for(int j=0; j<num.length; j++){
             	num[j] = sc.nextInt();
            }
            
            Arrays.sort(num);
            
            // 반복문 조건으로 최소값과 최대값 제외
            int sum = 0;
            for(int j=1; j<num.length-1; j++){
             	sum += num[j];
            }
            
            // 평균 계산 (소수점 반올림)
            double avg = (double) sum / (num.length - 2);
            int result = (int) Math.round(avg);
            
            System.out.println("#" + (i+1) + " " + result);
        }
	}
}