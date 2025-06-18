import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] table = br.readLine().split(" ");
		int H = Integer.parseInt(table[0]);
		int W = Integer.parseInt(table[1]);
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[W];
		
		for(int i=0; i<W; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int[] leftMax = new int[W];
		leftMax[0] = arr[0];
		for(int i=1; i<W; i++) {
			leftMax[i] = Math.max(leftMax[i-1], arr[i]);
		}
		
		int[] rightMax = new int[W];
		rightMax[W-1] = arr[W-1];
		for(int i=W-2; i>=0; i--) {
			rightMax[i] = Math.max(rightMax[i+1], arr[i]);
		}
		
		int total = 0;
		for(int i=0; i<W; i++) {
			int waterLevel = Math.min(leftMax[i], rightMax[i]);
			if(waterLevel > arr[i]) {
				total += waterLevel - arr[i];
			}
		}
		
		System.out.println(total);
	}
}
