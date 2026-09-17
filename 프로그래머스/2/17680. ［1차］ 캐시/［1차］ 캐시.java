import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        LinkedList<String> q = new LinkedList<>();
        
        int processTime = 0;
        
        String[] upperCaseCities = new String[cities.length];
        for (int i=0; i<cities.length; i++) {
            upperCaseCities[i] = cities[i].toUpperCase();
        }
        
        for (int i=0; i<upperCaseCities.length; i++) {     
            if (q.size() < cacheSize) {
                if (q.contains(upperCaseCities[i])) {
                    q.remove(q.indexOf(upperCaseCities[i]));
                    q.offerLast(upperCaseCities[i]);
                    processTime += 1;
                } else {
                    q.offerLast(upperCaseCities[i]);
                    processTime += 5;
                }
            } 
            
            // Queue가 캐시크기만큼 값이 들어있으면
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