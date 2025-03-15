import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int M = sc.nextInt();
        for(int i=0; i<M; i++) {
            int x = sc.nextInt();
            int result = binarySearch(A, x);

            if (result != -1) {
                System.out.println(1 + " ");
            }
            else {
                System.out.println(0 + " ");
            }
        }

    }

    public static int binarySearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        // lo가 hi보다 커지기 전까지 반복
        while (lo <= hi) {

            int mid = (lo + hi) / 2;

            if (target < arr[mid]) {
                hi = mid - 1;
            }

            else if (target > arr[mid]) {
                lo = mid + 1;
            }

            else {
                return mid;
            }
        }
        return -1;
    }
}

