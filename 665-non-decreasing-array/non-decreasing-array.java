class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0; // count modifications
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) return false; // more than one change not allowed
                
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1]; // modify nums[i]
                } else {
                    nums[i + 1] = nums[i]; // modify nums[i+1]
                }
            }
        }
        
        return true;
    }
}
