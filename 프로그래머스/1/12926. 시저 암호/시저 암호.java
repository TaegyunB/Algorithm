class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(" ");
                continue;
            }
            
            char c = s.charAt(i);
            int ascii = (int)c;
            
            System.out.println(ascii);
            
            if (ascii <= 90) {  // 대문자
                ascii += n;
                
                if (ascii > 90) {
                    int remain = ascii - 90;
                    ascii = 65;
                    ascii += remain - 1;
                    sb.append((char)ascii);
                } else {
                    sb.append((char)ascii);
                }
            } else {  // 소문자
                ascii += n;
                
                if (ascii > 122) {
                    int remain = ascii - 122;
                    ascii = 97;
                    ascii += remain - 1;
                    sb.append((char)ascii);
                } else {
                    sb.append((char)ascii);
                }
            }
        }
        
        
        return sb.toString();
    }
}