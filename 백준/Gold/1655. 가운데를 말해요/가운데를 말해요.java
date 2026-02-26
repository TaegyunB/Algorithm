import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 왼쪽(작은 값들): 최대힙 -> 중앙값(짝수면 작은 쪽)은 항상 여기의 루트
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		// 오른쪽(큰 값들): 최소힙
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			// maxHeap이 비었거나 x가 중앙값(=maxHeap.peek())보다 작거나 같으면 왼쪽
			if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
				maxHeap.offer(x);
			} else {
				minHeap.offer(x);
			}
			
			// 크기 균형 맞추기
			// 규칙: maxHeap.size() == minHeap.size() 또는 maxHeap.size() == minHeap.size() + 1
			if (maxHeap.size() < minHeap.size()) {
				maxHeap.offer(minHeap.poll());
			} else if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.offer(maxHeap.poll());
			}
			
			// 중앙값 출력: 항상 maxHeap 루트
			sb.append(maxHeap.peek()).append("\n");
		}
		
		System.out.println(sb);
	}
}
