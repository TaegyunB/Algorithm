class Solution {
    public int solution(int a, int d, boolean[] included) {
        
        int sum = a;
        int total = 0;
        
        for(int i=0; i<included.length; i++){
            if(included[i] == true){
                total += sum;
                sum += d;
            }
            else if(included[i] == false){
                sum += d;
            }
        }
        
        return total;
    }
}