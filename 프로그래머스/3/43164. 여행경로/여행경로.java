import java.util.*;

class Solution {
    
    static List<String> route;
    static boolean[] visited;
    String[] answer = {};
    
    public String[] solution(String[][] tickets) {
        
        // 목적지 기준 알파벳 순서로 정렬 -> 가장 먼저 찾은 경로가 정답
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        visited = new boolean[tickets.length];
        route = new ArrayList<>();
        
        route.add("ICN");
        dfs(tickets, route, "ICN");
        
        return answer;
    }
    
    private void dfs(String[][] tickets, List<String> route, String current) {
        
        // 모든 티켓을 사용한 경우
        if (route.size() == tickets.length + 1) {
            if (answer.length == 0) {  // 아직 정답이 없을 때만 저장 (덮어쓰기 방지)
                answer = route.toArray(new String[0]);
                // List -> Array로 변환
                // new String[0]: 변환할 배열의 타입을 지정, [0]으로 줘도 자바에서 알아서 route 크기에 맞게 배열을 만들어줌
                
                return;    
            }
        }
        
        for (int i=0; i<tickets.length; i++) {
            // 미사용 티켓이고 출발지가 현재인 경우
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                route.add(tickets[i][1]);
                
                dfs(tickets, route, tickets[i][1]);  // 다음 목적지로 재귀 호출
                
                // 백트래킹 - 이전 상태로 복원
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }
    }
}