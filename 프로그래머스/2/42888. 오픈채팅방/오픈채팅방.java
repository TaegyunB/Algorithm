import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        
        for (String order : record) {
            String[] userRecord = order.split(" ");
            
            if (userRecord[0].equals("Enter")) {
                users.put(userRecord[1], userRecord[2]);
            } else if (userRecord[0].equals("Change")) {
                users.put(userRecord[1], userRecord[2]);
            }
        }
        
        List<String> answer = new ArrayList<>();
        for (String order : record) {
            String[] userRecord = order.split(" ");
            String sentence = "";
            
            if (userRecord[0].equals("Enter")) {
                sentence = users.get(userRecord[1]) + "님이 들어왔습니다.";
                answer.add(sentence);
            } else if (userRecord[0].equals("Leave")) {{
                sentence = users.get(userRecord[1]) + "님이 나갔습니다.";
                answer.add(sentence);
            }}
        }
        
        return answer.toArray(new String[0]);
    }
}