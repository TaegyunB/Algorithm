class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int mul_all = 1;
        int sum_square = 0;
        
        for(int i=0; i<num_list.length; i++){
            mul_all *= num_list[i];
            sum_square += num_list[i];
        }
        
        sum_square *= sum_square;
        
        if(mul_all < sum_square){
            answer = 1;
        }
        else{
            answer = 0;
        }
        
        
        return answer;
    }
}