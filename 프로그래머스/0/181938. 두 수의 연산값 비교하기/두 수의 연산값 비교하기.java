class Solution {
    public int solution(int a, int b) {
    
        String str_ab = Integer.toString(a) + Integer.toString(b);
        int num_ab = Integer.parseInt(str_ab);
        int sum = 2 * a * b;
        
        if(num_ab > sum){
            return num_ab;
        }
        else{
            return sum;
        }
    }
}