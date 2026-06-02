import java.util.*;

class Solution {
    static int[] aAnswer = new int[]{1, 2, 3, 4, 5};
    static int[] bAnswer = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    static int[] cAnswer = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int a = 0;
        int b = 0;
        int c = 0;
        
        for (int i=0; i<answers.length; i++) {
            // a, b, c 길이에 맞게 각각 정답 비교
            if (answers[i] == aAnswer[i % aAnswer.length]) {
                a++;
            }
            
            if (answers[i] == bAnswer[i % bAnswer.length]) {
                b++;
            }
            
            if (answers[i] == cAnswer[i % cAnswer.length]) {
                c++;
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        int max = Math.max(a, Math.max(b, c));  // 가장 많이 맞힌 문제 수
        
        if (max == a) {
            answer.add(1);
        }
        
        if (max == b) {
            answer.add(2);
        }
        
        if (max == c) {
            answer.add(3);
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}