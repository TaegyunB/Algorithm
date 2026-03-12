import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 해당 인원이 신고를 성공한 인원이 몇명인지 카운트
        Map<String, Integer> result = new HashMap<>();
        for (int i=0; i<id_list.length; i++) {
            result.put(id_list[i], 0);
        }
        
        // 누가 누구를 신고했는지 정리
        Map<String, Integer> sumReport = new HashMap<>();
        for (String nameToName : report) {
            if (!sumReport.containsKey(nameToName)) {
                sumReport.put(nameToName, 1);
            } else {
                sumReport.put(nameToName, sumReport.getOrDefault(nameToName, 0) + 1);    
            }
        }
        
        // 신고 당한 사람이 몇 번 신고 당했는지 카운팅
        Map<String, Integer> cntReport = new HashMap<>();
        for (String reportList : sumReport.keySet()) {
            String[] splitName = reportList.split(" ");
            String reporter = splitName[0];
            String reported = splitName[1];
            
            cntReport.put(reported, cntReport.getOrDefault(reported, 0) + 1);
        }
        
        // K번 이상 신고를 당했으면 정지시켜야 하니깐 정지시킬 사람 이름 리스트 추출
        List<String> blockedPerson = new ArrayList<>();
        for (String finalName : cntReport.keySet()) {
            if (cntReport.get(finalName) >= k) {
                blockedPerson.add(finalName);
            }
        }
        
        // 정지시킨 사람을 신고한 사람이 누군지인지 구별하고 정지시킨 사람 중에 몇명을 신고했는지 카운팅
        for (String nameToName: sumReport.keySet()) {
            String[] splitName = nameToName.split(" ");
            String reporter = splitName[0];
            String reported = splitName[1];
            
             if (blockedPerson.contains(reported)) {
                 result.put(reporter, result.get(reporter) + 1);
             }
        }
        
        // 각 유저ID가 정지시킨 사람을 몇명이나 신고했는지 리스트로 반환
        int[] answer = new int[result.size()];
        for (int i=0; i<id_list.length; i++) {
            answer[i] = result.get(id_list[i]);
       }
        
        return answer;
    }
}