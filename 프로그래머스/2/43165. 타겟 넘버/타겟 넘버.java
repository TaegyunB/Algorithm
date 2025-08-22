class Solution {
    public int solution(int[] numbers, int target) {
        
        // DFS 시작 : 인덱스 0, 현재합 0, 카운트 0부터 시작
        return dfs(numbers, 0, 0, target, 0);
    }
    
    private int dfs(int[] numbers, int index, int current, int target, int cnt) {
        // 기저조건 : 모든 숫자를 다 사용했을 때
        if (index == numbers.length) {
            // 현재 합이 타겟과 같으면 1(경우의 수 1개), 아니면 0 반환
            return current == target ? 1 : 0;
        }
        
        // 경우의 수를 합치는 것
        return dfs(numbers, index+1, current + numbers[index], target, cnt) + 
            dfs(numbers, index+1, current - numbers[index], target, cnt);
    }
}