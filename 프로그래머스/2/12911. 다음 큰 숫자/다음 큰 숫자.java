class Solution {
    public int solution(int n) {
        
        int oneSum = 0;
        String binary = Integer.toString(n, 2);
        
        for (int i=0; i<binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                oneSum++;
            }    
        }
        
        n++;
        
        boolean flag = false;
        while (!flag) {
            String newBinary = Integer.toString(n, 2);
            int cntOne = 0;
            
            for (int i=0; i<newBinary.length(); i++) {
                if (newBinary.charAt(i) == '1') {
                    cntOne++;
                }    
            }
            
            if (oneSum == cntOne) {
                return n;
            }
            
            n++; 
        }
        
        return 0;
    }
}