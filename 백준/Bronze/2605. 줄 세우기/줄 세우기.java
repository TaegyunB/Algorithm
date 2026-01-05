import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] card = new int[N];
		
		List<Integer> line = new ArrayList<>();  // list 선언

		// 뽑은 번호 배열에 추가
		for (int i=0; i<N; i++) {
			card[i] = sc.nextInt();
		}
		
		// 줄 서기
		for (int i=0; i<N; i++) {
			if (i == 0) {  // 첫 번째
				line.add(1);
			} 
			else if (i == 1) {  //두 번째
				if (card[1] == 0) {  // 0 이면 뒤에 추가
					line.add(2);
				} else {  // 1 이면 첫 번재 자리에 추가
					line.add(0, 2);
				}
			} 
			else {  // 세 번째 이상
				int place = i - card[i];  // 추가되어야 할 자리 값
				line.add(place, i+1);
			}
		}
		
		for (int i=0; i<N; i++) {
			System.out.print(line.get(i) + " ");
		}
	}
}