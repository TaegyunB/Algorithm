import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        int[] maxDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        for(int i=0; i<T; i++) {
         	String date = sc.next();
            // year, month, day 로 나누기
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6, 8));
            
            // 날짜 유효성 판단
            if (month < 1 || month > 12 || day < 1 || day > maxDays[month]) {
                System.out.println("#" + (i+1) + " " + -1);
            }
            else {
                /*
                형식 지정자의 기본 구조
                - %: 형식 지정자의 시작을 나타냄
                - 0: 숫자 앞을 '0'으로 채운다는 의미 =
                - 4 또는 2: 최소 풀력 폭을 나타냄(출력 자릿수)
                - d: 정수를 나타내는 데이터 타입을 지정함
                */
             	System.out.printf("#%d %04d/%02d/%02d%n", (i+1), year, month, day);
            }
        }
	}
}