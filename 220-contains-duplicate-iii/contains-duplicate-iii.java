import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            Long num = (long) nums[i];
            
            // Find the smallest number >= num
            Long ceiling = set.ceiling(num);
            if (ceiling != null && ceiling - num <= valueDiff) {
                return true;
            }
            
            // Find the largest number <= num
            Long floor = set.floor(num);
            if (floor != null && num - floor <= valueDiff) {
                return true;
            }
            
            set.add(num);
            
            // maintain window size
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
