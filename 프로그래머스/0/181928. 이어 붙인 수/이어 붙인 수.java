class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        String even = "";
        String odd = "";
        
        for(int i=0; i<num_list.length; i++){
            if(num_list[i] % 2 == 0){
                String even_str = Integer.toString(num_list[i]);
                even += even_str;
            }
            else {
                String odd_str = Integer.toString(num_list[i]);
                odd += odd_str;
            }
        }
        
        int even_int = Integer.parseInt(even);
        int odd_int = Integer.parseInt(odd);
        
        answer = even_int + odd_int;
        
        return answer;
    }
}