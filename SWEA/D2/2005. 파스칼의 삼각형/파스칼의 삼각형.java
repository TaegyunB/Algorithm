import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();

            // N * N 크기의 2차원 배열로 파스칼의 삼각형 구현
            int[][] triangle = new int[N][N];

            // 파스칼의 삼각형 생성
            for(int i=0; i<N; i++) {  // i는 행 인덱스
                for(int j=0; j<=i; j++) {  // j는 열 인덱스 (각 행에서는 j<=i까지만 채움)
                    // 각 행의 마지막 원소는 항상 1
                    if(i == j) {
                        triangle[i][j] = 1;
                    }
                    // 각 행의 첫 번째 원소는 항상 1
                    else if(j == 0) {
                        triangle[i][j] = 1;
                    }
                    // 그 외의 원소는 왼쪽 위와 바로 위 원소의 합
                    else{
                        triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
                    }
                }
            }

            System.out.println("#" + tc);
            for(int i=0; i<N; i++) {
                for(int j=0; j<=i; j++) {
                    System.out.print(triangle[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
