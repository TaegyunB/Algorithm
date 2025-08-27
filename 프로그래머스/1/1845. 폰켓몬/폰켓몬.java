import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int findSize = nums.length / 2;
        
        // Set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        if (findSize < set.size() && nums.length > findSize) {
            return findSize;
        } else {
            return set.size();
        }
    }
}