import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {

            int N = sc.nextInt();
            int[] arr = new int[N];

            for(int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }

            int maxPrice = 0;  // 최대 가격
            long maxProfit = 0;  // 최대 이익
            /*
            장기간 테스트 케이스(N이 매우 큰 경우)에서 발생할 수 있는 정수 오버플로우 문제를 고려하지 않음
                - 문제에서 N이 최대 1,000,000이고 각 날의 매매가가 최대 10,000이라고 했음
                - 최악의 경우 이익은 1,000,000 * 10,000 = 10,000,000,000(100억)까지 될 수 있음
                - 이는 int 범위를 벗어남
            => maxProfit 변수를 long 타입으로 선언해야함
             */

            // 뒤에서부터 탐색 (미래 정보를 활용하기 위함)
            for(int i=N-1; i>=0; i--) {

                // 현재 가격이 지금까지의 최대 가격보다 크면 최대 가격 갱신
                if(arr[i] > maxPrice) {
                    maxPrice = arr[i];
                }

                // 현재 가격이 최대 가격보다 작으면 차익을 계산하여 이익에 추가
                else {
                    maxProfit += maxPrice - arr[i];
                }
            }
            System.out.println("#" + tc + " " + maxProfit);
        }
    }
}
