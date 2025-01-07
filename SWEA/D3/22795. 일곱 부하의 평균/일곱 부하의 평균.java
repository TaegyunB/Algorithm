import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
		int T = sc.nextInt();
        
        for(int i=0; i<T; i++) {
         	int[] people = new int[6];
            int sum = 0;
            int max = 0;
            
            for(int j=0; j<6; j++) {
             	people[j] = sc.nextInt();   
                sum += people[j];
                if(people[j] > max) {
                 	max = people[j];   
                }
            }
            
            // 사라진 부하의 키 찾기
            int x = max + 1;
            while(true) {
             	if((sum + x) % 7 == 0){ // 모든 부하의 키의 평균이 정수여야 하기 때문
                 	System.out.println(x);   
                    break;
                }
                x++;
            }
        }
	}
}