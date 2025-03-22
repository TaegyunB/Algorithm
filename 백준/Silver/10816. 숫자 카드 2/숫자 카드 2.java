import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 이진 탐색을 위해 배열 정렬

        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder 객체 생성 (문자열 연산 최적화)

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();

            sb.append(upperBound(arr, x) - lowerBound(arr, x)).append(" ");
        }
        System.out.println(sb);
    }

    /**
     * 이진 탐색을 사용하여 배열에서 key 이상인 값이 처음 나타나는 위치를 찾는 메소드
     * @param arr 탐색할 정렬된 배열
     * @param key 찾을 값
     * @return key 값이 처음으로 나타는 인덱스
     */
    public static int lowerBound(int[] arr, int key) {
        int lo = 0;  // 탐색 범위의 시작점
        int hi = arr.length; // 탐색 범위의 끝점 (배열의 길이로 초기화)

        // 탐색 범위가 더 이상 없을 때까지 반복
        while(lo < hi) {
            int mid = (lo + hi) / 2;

            // 중간 값이 key 이상이면, 더 왼쪽(작은 인덱스)을 탐색
            if(arr[mid] >= key) {
                hi = mid;
            }

            // 중간 값이 key보다 작으면, 더 오른쪽(큰 인덱스)을 탐색
            else {
                lo = mid + 1;
            }
        }
        return lo; // key 이상인 값이 처음 나타나는 위치 반환
    }

    /**
     * 이진 탐색을 사용하여 배열에서 key 초과인 값이 처음 나타나는 위치를 찾는 메소드
     * @param arr 탐색할 정렬된 배열
     * @param key 찾을 값
     * @return key 초과인 값이 처음 나타나는 인덱스
     */
    public static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        // 탐색 범위가 더 이상 없을 때까지 반복
        while(lo < hi) {
            int mid = (lo + hi) / 2;

            // 중간 값이 key보다 크면, 더 왼쪽을 탐색
            if(arr[mid] > key) {
                hi = mid;
            }

            // 중간 값이 key 이하이면, 더 오른쪽을 탐색
            else {
                lo = mid + 1;
            }
        }
        return lo; // key 초과인 값이 처음 나타나는 위치 반환
    }
}
