import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    // 좌표와 거리를 저장하는 클래스
    static class Pos {
        int x, y, dist;

        Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int problemNum = 1;

        while (true) {
            int N = sc.nextInt();
            sc.nextLine();  // 버퍼에 남은 개행문제 제거

            // 종료 조건
            if (N == 0) {
                break;
            }

            int[][] arr = new int[N][N];
            // arr 생성
            for (int i=0; i<N; i++) {
                String input = sc.nextLine();
                String[] split = input.split(" ");

                for (int j=0; j<split.length; j++) {
                    arr[i][j] = Integer.parseInt(split[j]);
                }
            }

            int result = dijkstra(0, 0, N, arr);

            System.out.printf("Problem %d: %d\n", problemNum, result);
            problemNum++;
        }
    }

    // 다익스트라 : (0,0)에서 (N-1, N-1)까지의 최소 비용 계산
    static int dijkstra(int x, int y, int N, int[][] arr) {
        // 거리 기준 오름차순으로 정렬하는 우선순위 큐
        PriorityQueue<Pos> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        // 거리 배열을 무한대로 초기화
        int[][] distArr = new int[N][N];
        for (int i=0; i<N; i++) {
            Arrays.fill(distArr[i], Integer.MAX_VALUE);
        }

        pq.offer(new Pos(x, y, arr[x][y]));
        distArr[x][y] = arr[x][y];

        while (!pq.isEmpty()) {
            Pos pos = pq.poll();
            int cx = pos.x;
            int cy = pos.y;
            int cdist = pos.dist;

            // 이미 더 짧은 경로로 처리된 노드라면 스킵 (최적화)
            if (cdist > distArr[cx][cy]) {
                continue;
            }

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int newDist = distArr[cx][cy] + arr[nx][ny];

                    if (distArr[nx][ny] <= newDist) {
                        continue;
                    }
                    distArr[nx][ny] = newDist;
                    pq.offer(new Pos(nx, ny, newDist));
                }
            }
        }
        return distArr[N-1][N-1];
    }
}