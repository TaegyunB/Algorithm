class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if(ineq.equals("<")){
            if(eq.equals("=")){
                // 조건식 ? 참일 때 반환할 값 : 거짓일 때 반환할 값;
                return n <= m ? 1 : 0; 
            }
            else{
                return n < m ? 1 : 0;
            }
        }
        else if(ineq.equals(">")){
            if(eq.equals("=")){
                return n >= m ? 1 : 0;
            }
            else{
                return n > m ? 1 : 0;
            }
        }
        // 기본 반환값을 추가하여 예상치도 못한 ineq 값에 대해 처리
        return 0;
    }
}