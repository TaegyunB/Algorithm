import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i<numbers.length-1; i++) {
            int a = numbers[i];
            
            for (int j=i+1; j<numbers.length; j++) {
                int b = numbers[j];
                int sum = a + b;
        
                if (!list.contains(sum)) {
                    list.add(sum);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}