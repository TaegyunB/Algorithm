import java.util.Scanner;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

public class Solution {
	

	public static void main(String[] args){
			
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int T = Integer.parseInt(br.readLine());
		int T = sc.nextInt();  // sc.nextInt()는 숫자만 읽고, 개행 문자(\n)는 읽지 않
		sc.nextLine();  // 그래서 빈 줄을 출력해줘야 함
		
		for(int tc=1; tc<=T; tc++) {
			
			int max_width = 0;
			int max_height = 0;
			int[][] arr = new int[10][10];
			
			for(int i=0; i<2; i++) {
				
//				String[] position = br.readLine().split(" ");
//				String[] position = sc.nextLine().split(" ");
					
//				int x1 = Integer.parseInt(position[0]);
//				int y1 = Integer.parseInt(position[1]);
//				int x2 = Integer.parseInt(position[2]);
//				int y2 = Integer.parseInt(position[3]);
				
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				int x2 = sc.nextInt();
				int y2 = sc.nextInt();
				
				for(int x=x1; x<=x2; x++) {
					for(int y=y1; y<=y2; y++) {
						arr[x][y] += 1;
					}
				}
			}
			
			for(int x=0; x<10; x++) {
				
				int width = 0;
				for(int y=0; y<10; y++) {
					if(arr[x][y] == 2) {
						width++;
					}
				}
				if(width > max_width) {
					max_width = width;
				}
			}
			
			for(int y=0; y<10; y++) {
				
				int height = 0;
				for(int x=0; x<10; x++) {
					if(arr[x][y] == 2) {
						height++;
					}
				}
				if(height > max_height) {
					max_height = height;
				}
			}
			
			System.out.printf("#%d %d %d\n", tc, max_width, max_height);			
		}
	}
}
