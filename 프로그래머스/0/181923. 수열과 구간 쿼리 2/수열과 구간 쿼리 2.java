import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {

        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<queries.length; i++){
            int standard = queries[i][2];
            int min = Integer.MAX_VALUE; // int 타입이 가질 수 있는 가장 큰 값
            boolean found = false;
            
            for(int j=queries[i][0]; j<=queries[i][1]; j++){
                if(standard < arr[j]){
                    min = Math.min(arr[j], min);
                    found = true;
                }
            }
            
            if(found){
                answer.add(min);
            }
            else{
                answer.add(-1);
            }
        
        }
        return answer.stream().mapToInt(i -> i).toArray();
        
        // stream(): 데이터의 흐름을 제어하는 API로, 컬렉션(List, Set 등)이나 배열 등의 데이터에 대해 반복, 필터링, 매핑 등의 작업을 편리하게 수행
        // mapToInt(i -> i): 매핑 작업을 수행. 스트림은 Integer 객체를 처리 but 우리가 원하는 결과는 int[] 배열
        // mapToInt() -> 각 요소를 int타입으로 변환할 때 사용하는 메소드
        // i -> i : 람다 표현식으로 입력받은 i를 그대로 반환하는 역할을 함. 즉, 입력값과 출력값이 동일
        // toArray() -> 배열로 수집
    }
}