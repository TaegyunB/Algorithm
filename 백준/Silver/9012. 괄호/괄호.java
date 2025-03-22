import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            String s = sc.next();
            boolean result = check(s);

            if (result) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }

    private static boolean check(String s) {
        Stack<String> stack = new Stack<>();

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                stack.push(String.valueOf(s.charAt(j)));
            } else if (s.charAt(j) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
