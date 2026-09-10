import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        // 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i=0; i<timetable.length; i++) {
            // substring 함수로 시간이랑 분 나누고
            int hour = Integer.parseInt(timetable[i].substring(0, 2));
            int minute = Integer.parseInt(timetable[i].substring(3, 5));
            
            // 분 값으로 변환하기
            int changeToMinute = (hour * 60) + minute;
            pq.offer(changeToMinute);
        }
        
        // System.out.println(pq);
        // System.out.println(pq.peek());
        
        int startShuttle = 540;  // "09:00"을 분으로 바꾼 값
        int cnt = 0;  // 버스에 탄 인원 수 -> 마지막 버스에 몇 명이 탔는지만 알면 됨
        int lastTime = 0;
        
        // 셔틀 운행 횟수만큼
        for (int i=0; i<n; i++) {
            cnt = 0;  // 마지막 버스만 계산하면 되기 때문에 계속 0으로 초기화 -> 마지막 버스만 계산
            
            // 한 셔틀에 탈 수 있는 최대 크루 수 만큼
            for (int j=0; j<m; j++) {
                // 도착한 셔틀 시간에 줄에 선 것도 탈 수 있음
                if (!pq.isEmpty() && pq.peek() <= startShuttle) {
                    lastTime = pq.poll();
                    cnt++;
                } 
            }
            
            if (i == n-1) {  // 다음 버스가 없으면 continue
                continue;
            } else {  // 다음 버스가 있으면 셔틀 운행 간격를 기존 시간에 더하기
                startShuttle += t;
            }
        }
        
        String answer = "";
        if (cnt == m) {  // 자리가 남아있지 않기 때문에 마지막 사람보다 1분이라도 더 빨리 와야 탈 수 있음
            answer = timeToString(lastTime - 1);
        } else if (cnt < m) {  // 자리가 남아있기 때문에 셔틀 출발시간에만 와도 탈 수 있음
            answer = timeToString(startShuttle);
        }
        
        return answer;
    }
    
    // int 시간을 String 시간으로 변환하는 함수
    private String timeToString(int time) {
        int hour = time / 60;
        int minute = time % 60;
        
        String sHour = "";
        String sMin = "";
        if (hour < 10) {
            sHour = "0" + String.valueOf(hour);
        } else {
            sHour = String.valueOf(hour);
        }
        
        if (minute < 10) {
            sMin = "0" + String.valueOf(minute);
        } else {
            sMin = String.valueOf(minute);
        }
        
        return sHour + ":" + sMin;
    }
}