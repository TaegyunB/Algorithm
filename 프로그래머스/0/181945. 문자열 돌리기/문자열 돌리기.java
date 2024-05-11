import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int len = a.length(); // 길이 저장
        
        for(int i=0; i<len; i++){
            System.out.println(a.charAt(i)); // 문자열의 i번째 글자를 char로 반환한다.
        }
    }
}