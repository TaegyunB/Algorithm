import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc=1; tc<=10; tc++) {
			int tcNum = sc.nextInt();
			
			int num = sc.nextInt();
			int times = sc.nextInt();
			
			// 재귀 함수 호출: num을 times번 곱한 결과 계산
			// answer 초기값 1, 카운터 0부터 시작
			int answer = numTimes(1, num, times, 0);
			
			System.out.printf("#%d %d\n", tcNum, answer);
		}
	}
	
	/**
	 * 재귀를 이용한 거듭제곱 계산 함수
	 * num을 times번 곱하여 num^times를 계산
	 * @param answer 현재까지의 곱셈 결과 (누적값)
	 * @param num 밑이 되는 숫자 (매번 곱할 값)
	 * @param times 목표 곱셈 횟수
	 * @param cnt 현재까지 곱한 횟수
	 * @return num^times의 결과값
	 */
	static int numTimes(int answer, int num, int times, int cnt) {
		// 기저 조건: 목표 횟수만큼 곱했으면 결과 반환
		if (cnt == times) {
			return answer;
		}
		
		else {
			answer *= num;
			return numTimes(answer, num, times, cnt+1);  // cnt++하면 StackOverflowError 에러가 발생 ->후위 증가 연산자이기 때문에 cnt=0이 전달되어 무한 재귀
		}
	}
}