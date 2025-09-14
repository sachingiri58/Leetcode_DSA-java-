class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int slow = i, fast = i;
            
            // direction: +ve or -ve
            boolean isForward = nums[i] > 0;
            
            while (true) {
                slow = nextIndex(nums, isForward, slow);
                if (slow == -1) break;
                
                fast = nextIndex(nums, isForward, fast);
                if (fast == -1) break;
                
                fast = nextIndex(nums, isForward, fast);
                if (fast == -1) break;
                
                if (slow == fast) return true;
            }
        }
        
        return false;
    }
    
    private int nextIndex(int[] nums, boolean isForward, int current) {
        boolean direction = nums[current] > 0;
        
        // check direction consistency
        if (isForward != direction) return -1;
        
        int n = nums.length;
        int next = (current + nums[current]) % n;
        
        if (next < 0) next += n; // handle negative index
        
        // self-loop not allowed
        if (next == current) return -1;
        
        return next;
    }
}
