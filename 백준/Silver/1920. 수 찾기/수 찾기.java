import java.util.Scanner;
import java.util.HashSet;

public class Main  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashSet<Integer> A = new HashSet<>();
        /*
        HashSet의 역할
            - 중복 없는 데이터 저장
            - 빠른 검색
                - contains() 메소드를 사용
            - 해시 기반 자료구조
            - 순서 보장 없음
         */


        for(int i=0; i<N; i++) {
            A.add(sc.nextInt());
        }


        int M = sc.nextInt();
        for(int i=0; i<M; i++) {
            int x = sc.nextInt();
            boolean result = false;

            if (A.contains(x)) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }

        }
    }
}
