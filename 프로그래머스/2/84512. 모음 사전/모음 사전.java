class Solution {
    
    static String[] vowels = {"A", "E", "I", "O", "U"};
    static StringBuilder currentWord = new StringBuilder();
    static String targetWord;
    static int count = 0;
    
    public int solution(String word) {
        targetWord = word;
        dfs(currentWord);
        
        return count - 1;
    }
    
    private void dfs(StringBuilder currentWord) {
        count++;
        
        if (targetWord.equals(currentWord.toString())) {
            return;
        }
        
        if (currentWord.length() == vowels.length) {
            return;
        }
        
        for (int i=0; i<vowels.length; i++) {
            currentWord.append(vowels[i]);
            dfs(currentWord);
            
            if (targetWord.equals(currentWord.toString())) {
                return;
            }
            
            currentWord.deleteCharAt(currentWord.length() - 1);
        }
    }
}