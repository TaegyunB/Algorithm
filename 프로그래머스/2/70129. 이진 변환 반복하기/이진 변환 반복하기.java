class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        // Integer.toBinaryString
        // Integer.parseInt("", 진수)
        int cntRound = 0;
        int cntZero = 0;
        
        while (s.length() != 1) {
            StringBuilder sb = new StringBuilder();
            
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) != '0') {
                    sb.append(s.charAt(i));
                } else {
                    cntZero++;
                }
            }
            
            int len = sb.length();
            s = Integer.toBinaryString(len);
            cntRound++;
        }
        
        return new int[]{cntRound, cntZero};
    }
}