import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// 각 노드의 자식 리스트를 저장할 2차원 리스트 생성
		List<List<Integer>> tree = new ArrayList<>();
		for (int i=0; i<N; i++) {
			tree.add(new ArrayList<>());
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int root = -1;  // 루트 노드를 저장할 변수
		
		// 부모 트리에 자식들 넣기
		for (int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			
			if (parent == -1) {  // 부모가 없으면 루트 노드
				root = i;
			}
			else {
				// 부모 노드의 자식 리스트에 현재 노드(i)를 추가
				tree.get(parent).add(i);				
			}
		}
		
		int cutNode = Integer.parseInt(br.readLine());
		
		// 삭제할 노드가 루트인 경우, 전체 트리가 사라지므로 리프 노드는 0개
		if (root == cutNode) {
			System.out.println(0);
			return;
		}
		
		// BFS를 이용해 삭제할 노드와 그 자손들을 모두 표시
		Deque<Integer> queue = new ArrayDeque<>();
		boolean[] deleted = new boolean[N];  // 각 노드의 삭제 여부를 저장
		queue.offerLast(cutNode);  // 삭제할 노드부터 시작
		deleted[cutNode] = true;  // 삭제 표시
		
		// 현재 노드의 모든 자식을 순회하면서 삭제 표시하기
		while (!queue.isEmpty()) {
			int curNode = queue.pollFirst();
			
			for (int child : tree.get(curNode)) {
				if (!deleted[child]) {  // 아직 삭제 표시 안 된 자식이라면
					deleted[child] = true;  // 삭제 표시
					queue.offerLast(child);  // 큐에 추가하여 그 자식의 자손들도 탐색
				}
			}
		}
		
		// 삭제 후 남은 트리에서 리프 노드 개수 세기
		int cnt = 0;
		for (int i=0; i<N; i++) {
			if (deleted[i]) {  // 이미 삭제된 노드는 건너뜀
				continue;
			}
			
			// 현재 노드가 리프 노드인지 확인
			boolean leaf = true;
			for (int child : tree.get(i)) {  // i번 노드의 모든 자식을 확인
				if (!deleted[child]) {  // 살아있는 자식이 하나라도 있으면
					leaf = false;  // 리프가 아님
					break;
				}
			}
			// 자식이 없거나, 모든 자식이 삭제된 경우 leaf = true 유지
			
			if (leaf) {
				cnt++;  // 리프 노드 개수 증가
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);
	}
}
