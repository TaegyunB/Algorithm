import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			int tcNum = Integer.parseInt(br.readLine());
			int[] studentsNum = new int[1001];  // 1000명 배열 선언
			
			String[] arr = br.readLine().split(" ");
			
			int maxArr = 0;
			for(int i=0; i<arr.length; i++) {
				int arrNum = Integer.parseInt(arr[i]);
				studentsNum[arrNum]++;
				
				if (studentsNum[arrNum] >= studentsNum[maxArr]) {  // 최빈수 값 갱신
					maxArr = arrNum;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(maxArr).append("\n");
		}
		
		System.out.println(sb);
	}

}
