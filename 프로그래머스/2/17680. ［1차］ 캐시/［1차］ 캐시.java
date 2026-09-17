import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        // cacheSize가 0이면 캐시 교체 알고리즘을 사용할 수 없기 때문에 그냥 다 MISS 처리
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        LinkedList<String> q = new LinkedList<>();  // Queue로 할라고 했는데 중간에서 제거해야하는 상황도 있어서 LinkedList 사용
        int processTime = 0;  // 총 실행시간
        
        // 대소문자 구별을 하지 않는다고 해서 모든 도시를 다 대문자로 변환
        String[] upperCaseCities = new String[cities.length];
        for (int i=0; i<cities.length; i++) {
            upperCaseCities[i] = cities[i].toUpperCase();
        }
        
        for (int i=0; i<upperCaseCities.length; i++) {     
            // cacheSize 보다 작을 때도 겹치는 도시가 있을 수 있으니 
            if (q.size() < cacheSize) {
                // 겹치면 갱신하는 로직 추가 - HIT
                if (q.contains(upperCaseCities[i])) {
                    q.remove(q.indexOf(upperCaseCities[i]));
                    q.offerLast(upperCaseCities[i]);
                    processTime += 1;
                } else { // 겹치지 않으면 그냥 추가 - MISS
                    q.offerLast(upperCaseCities[i]);
                    processTime += 5;
                }
            } 
            
            // Queue가 cacheSize만큼 값이 들어있으면
            else { 
                if (!q.contains(upperCaseCities[i])) {  // MISS
                    q.pollFirst();
                    processTime += 5;
                    q.offerLast(upperCaseCities[i]);
                } else {  // HIT
                    q.remove(q.indexOf(upperCaseCities[i]));
                    q.offerLast(upperCaseCities[i]);
                    processTime += 1;
                }
            }
        }
        
        return processTime;
        
    }
}