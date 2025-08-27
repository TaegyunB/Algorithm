import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);
        
        for (int i=0; i<phone_book.length-1; i++) {
            String current = phone_book[i];
            String target = phone_book[i+1];
            
            // startsWith -> 처음부터 확인하는 String 메서드
            if (target.startsWith(current)) {
                return false;
            }
        }
        return true;
    }
}