import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		List<Meeting> list = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new Meeting(start, end));
		}
		
		// Comparable에 정의된 compareTo 기준으로 정렬
		// 여기서 실제 정렬이 수행됨
		Collections.sort(list);
		
		int cnt = 0;
		int endTime = 0;
		for (int i=0; i<N; i++) {
			Meeting meeting = list.get(i);
			int start = meeting.start;
			int end = meeting.end;
			
			// 현재 회의의 시작 시간이 이전 회의 종료 시간 이상이면 선택 가능
			if (start >= endTime) {
				cnt++;
				endTime = end;  // 종료 시간 갱신
			}
		}
		
		System.out.println(cnt);
	}
	
	// Comparable을 구현해서 "정렬 기준(자연 순서)"을 정의함
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			
			if (this.end == o.end) {
				// 종료 시간이 같으면 시작 시간 오름차순
				return Integer.compare(this.start, o.start);
			}
			// 종료 시간 오름차순
			return Integer.compare(this.end, o.end);
		}
	}
}
