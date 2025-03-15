import java.util.Scanner;
import java.util.HashSet;

public class Main  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashSet<Integer> arr = new HashSet<>();

        for(int i=0; i<N; i++) {
           arr.add(sc.nextInt());
        }

        int M = sc.nextInt();
        for(int i=0; i<M; i++) {
            int x = sc.nextInt();

            if(arr.contains(x)) {
                System.out.print(1 + " ");
            }
            else {
                System.out.print(0 + " ");
            }
        }
    }
}
