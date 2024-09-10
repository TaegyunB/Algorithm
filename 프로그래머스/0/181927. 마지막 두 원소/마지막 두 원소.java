class Solution {
    public int[] solution(int[] num_list) {
        
        int[] answer = new int[num_list.length + 1]; // 새로운 배열 생성
        System.arraycopy(num_list, 0, answer, 0, num_list.length); // 새로운 배열에 데이터 추가
        
        int last = num_list[num_list.length - 1]; // 음수 인덱스 사용 불가
        int secondLast = num_list[num_list.length - 2];
        
        if(last > secondLast){
            answer[answer.length-1] = last - secondLast;
        }
        else{
            answer[answer.length-1] = last * 2;
        }
        
        return answer;
    }
}