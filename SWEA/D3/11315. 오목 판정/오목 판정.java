import java.util.Scanner;

public class Solution {

    private static int[] dx = {0, 1, 1, 1};
    private static int[] dy = {1, 1, 0, -1};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();

            char[][] arr = new char[N][N];

            for (int j=0; j<N; j++) {
                String input = sc.next();
                for (int k=0; k<N; k++) {
                    arr[j][k] = input.charAt(k);
                }
            }

            boolean found = false;
            for (int j=0; j<N; j++) {
                for (int k=0; k<N; k++) {
                    if (arr[j][k] == 'o') {
                        boolean result = findResult(arr, N, j, k);

                        if (result) {
                            found = true;
                            break;
                        } else {
                            continue;
                        }
                    }
                }

                if (found) {
                    System.out.printf("#%d YES\n", tc);
                    break;
                }
            }
            if (!found) {
                System.out.printf("#%d NO\n", tc);
            }
        }
    }

    // 오목 확인 여부
    public static boolean findResult(char[][] arr, int N, int x, int y) {
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int cnt = 1;

            while (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 'o') {
                nx += dx[i];
                ny += dy[i];
                cnt++;
            }

            if (cnt >= 5) {
                return true;
            }
        }
        return false;
    }
}
