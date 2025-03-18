import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        // 방향 배열: 우(0), 하(1), 좌(2), 상(3) 순서로 이동
        int[] di = {0, 1, 0, -1};  // 행(i) 방향 이동 값 
        int[] dj = {1, 0, -1, 0};  // 열(j) 방향 이동 값

        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();

            int[][] arr = new int[N][N];  // N * N 배열 생성

            int i = 0, j = 0;  // 시작 위치 
            int num = 1;  // 시작 숫자 1부터
            int dir = 0;  // 방향

            
            // N * N 까지의 숫자를 배열에 채움
            while (num <= N*N) {
                arr[i][j] = num;  // 현재 위치에 숫자 채우기
                num++;  // 숫자 증가

                // 다음 위치 계산
                int ni = i + di[dir];
                int nj = j + dj[dir];

                // 다음 위치가 배열 범위를 벗어나거나 이미 숫자가 채워진 경우 방향 전환
                if (ni < 0 || ni >= N || nj < 0 || nj >= N || arr[ni][nj] != 0) {
                    dir = (dir + 1) % 4;
                    // 새 방향으로 다음 위치 재계산
                    ni = i + di[dir];
                    nj = j + dj[dir];
                }

                // 다음 위치로 이동
                i = ni;
                j = nj;


            }

            System.out.println("#" + tc);
            for (int x=0; x<N; x++) {
                for (int y=0; y<N; y++) {
                    System.out.print(arr[x][y] + " ");
                }
                System.out.println();
            }
        }
    }
}
