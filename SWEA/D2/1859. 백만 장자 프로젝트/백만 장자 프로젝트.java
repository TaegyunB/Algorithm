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

            // 뒤에서부터 탐색 (미래 정보를 활용하기 위함)
            for(int i=N-1; i>=0; i--) {
                
                // 현재 가격이 지금까지의 최대 가격보다 크다면 최대 가격 갱신
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
