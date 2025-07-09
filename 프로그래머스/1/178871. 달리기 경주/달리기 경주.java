import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        // 키, 값을 한 쌍으로 저장
        Map<String, Integer> map = new HashMap<>();
        
        // map에 값 삽입(키, 값)
        for(int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++) {
            int idx = map.get(callings[i]);
            
           // 위치 변경
            String name = players[idx-1];
            players[idx-1] = players[idx];
            players[idx] = name;
            
            // map 값 변경
            map.put(players[idx], idx);
            map.put(players[idx-1], idx-1);
        }
        
        return players;
    }
}