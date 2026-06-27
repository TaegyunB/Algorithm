class Solution {
    
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static int count = 0;
    static String targetWord;
    
    public int solution(String word) {
        targetWord = word;
        StringBuilder sb = new StringBuilder();
        
        dfs(sb);
        return count;
    }
    
    private void dfs(StringBuilder currentWord) {
        if (targetWord.equals(currentWord.toString())) {
            return;
        }
        
        if (currentWord.length() == vowels.length) {
            return;
        }
        
        for (char vowel : vowels) {
            count++;
            dfs(currentWord.append(vowel));
            
            if (targetWord.equals(currentWord.toString())) {
                return;
            }
            
            currentWord.deleteCharAt(currentWord.length()-1);
        }
    }
}