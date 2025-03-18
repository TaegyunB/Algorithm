import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc=1; tc<=T; tc++) {
            String word = sc.next();
            int wordLen = word.length();

            boolean result = true;

            int i = 0;
            int j = wordLen-1;

            while(i < j) {
                if(word.charAt(i) != word.charAt(j)) {
                    result = false;
                    break;
                }
                i += 1;
                j -= 1;
            }

            if(result) {
                System.out.println("#" + tc + " " + 1);
            }
            else {
                System.out.println("#" + tc + " " + 0);
            }
        }
    }
}
