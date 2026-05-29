import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        // today 파싱
        String[] todaySplit = today.split("\\.");  // 주의
        
        int tyear = Integer.parseInt(todaySplit[0]);
        int tmonth = Integer.parseInt(todaySplit[1]);
        int tdate = Integer.parseInt(todaySplit[2]);
        
        // terms -> Map
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<terms.length; i++) {
            String[] term = terms[i].split(" ");
            
            map.put(term[0].charAt(0), Integer.parseInt(term[1]));
        }
        
        // privacies
        for (int i=0; i<privacies.length; i++) {
            String privacy = privacies[i];
            String[] priSplit = privacy.split(" ");
            
            String availableDate = priSplit[1];
            
            // 날짜 파싱
            String[] dateSplit = priSplit[0].split("\\.");
            int year = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]);
            int date = Integer.parseInt(dateSplit[2]);
            
            int getMonth = map.get(availableDate.charAt(0));
            
            // 만료일 계산
            month += getMonth;
            while (month > 12) { // 유효기간은 1 이상 100 이하이기 때문에
                year++;
                month -= 12;
            }
            
            // 만료일 <= 오늘이면 파기
            if (year < tyear) {  // 오늘 년도보다 작으면
                answer.add(i+1);
            } else if (year == tyear && month < tmonth) {  // 년도는 같은데 오늘 월보다 작으면
                answer.add(i+1);
            } else if (year == tyear && month == tmonth && date <= tdate) {  // 년도랑 월은 같은데 일이 작으면
                answer.add(i+1);
            }
        }
            
        return answer.stream().mapToInt(x -> x).toArray();
    }
}