class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2; // Start from index 2 because first two elements are always allowed
        for (int i = 2; i < nums.length; i++) {
            // Compare current number with the number at position k-2
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
