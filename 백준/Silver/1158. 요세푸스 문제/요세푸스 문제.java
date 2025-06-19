import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> deque = new LinkedList<>();
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			deque.offerLast(i+1);
		}
		
		
		while(deque.size() != 0) {
			for(int i=0; i<K-1; i++) {
				int num = deque.pollFirst();
				deque.offerLast(num);
			}
			
			arr.add(deque.pollFirst());
		}
		
		System.out.print("<");
		for(int i=0; i<N; i++) {
			if(i==N-1) {
				System.out.print(arr.get(i));
			} else {
				System.out.print(arr.get(i) + ", ");				
			}
		}
		
		System.out.print(">");
	}
}
