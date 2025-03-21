import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int max_sum = 0;
            for(int i=0; i<=N-M; i++) {
                for(int j=0; j<=N-M; j++) {

                    int sum = 0;
                    // M * M 크기 만큼 탐색
                    for(int k=i; k<i+M; k++) {
                        for(int l=j; l<j+M; l++) {
                            sum += arr[k][l];
                        }
                    }
                    if(sum > max_sum) {
                        max_sum = sum;
                    }
                }
            }
            System.out.println("#" + tc + " " + max_sum);
        }
    }
}
