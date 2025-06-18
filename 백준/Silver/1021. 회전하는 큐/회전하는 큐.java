import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> deque = new LinkedList<>();
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		for(int i=1; i<=N; i++) {
			deque.offer(i);
		}
		
		String[] targetInput = br.readLine().split(" ");
		int[] targets = new int[M];
		
		for(int i=0; i<M; i++) {
			targets[i] = Integer.parseInt(targetInput[i]);
		}
		
		int cnt = 0;
		int finish = 0;
		while(finish != M) {
			int target = deque.indexOf(targets[finish]);  // 찾고자 하는 값의 인덱스
			
			if(deque.indexOf(targets[finish]) == 0) {  // target이 가장 앞에 있으면
				deque.pollFirst();  // 앞의 값 삭제
				finish++;
			} else {
				int half = 0;
				
				if(deque.size() % 2 == 0) {  // deque의 사이즈가 짝수이면 -> 인덱스가 0부터 시작하니깐 -1을 해줘야 짝수일 때 중간값을 찾을 수 있음
					half = deque.size() / 2 - 1;  
				} else {  // deque의 사이즈가 홀수이면
					half = deque.size() / 2;
				}
				
				if(half >= target) {  // deque 사이즈의 반이 target보다 크거나 같으면(target이 왼쪽에 있으면)
					// target 값 동안 반복
					for(int i=0; i<target; i++) {
						int num = deque.pollFirst(); // deque 맨 앞의 값 꺼낸 후
						deque.offerLast(num);  // deque 맨 뒤에 추가
						cnt++;
					}
				} else {  // deque 사이즈의 반이 target보다 작으면(target이 오른쪽에 있으면)
					// target 값 부터 deque 사이즈동안 반복
					for(int i=target; i<deque.size(); i++) {
						int num = deque.pollLast();  // deque 맨 뒤의 값 꺼낸 후
						deque.offerFirst(num);  // deque 맨 앞에 추가
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
