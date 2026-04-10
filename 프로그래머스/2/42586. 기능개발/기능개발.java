import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] pList = new int[progresses.length];
        // 각 기능의 완료 일수 계산
        for (int i=0; i<progresses.length; i++) {
            pList[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        
        // 배포 그룹 묶기
        int i = 0;
        while (i < pList.length) {
            int cnt = 1;
            int curDay = pList[i];  // 현재 그룹의 기준 일수
            
            // 다음 기능들이 maxDay 이하면 같이 배포
            while (i + cnt < pList.length && curDay >= pList[i+cnt]) {
                cnt++;
            }
            
            i += cnt;  // 다음 그룹으로 이동
            list.add(cnt);
        }
        
        return list.stream().mapToInt(x -> x).toArray();
    }
}