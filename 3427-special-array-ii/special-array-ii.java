import java.util.*;

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        boolean[] ans = new boolean[m];
        
   
        int[] bad = new int[n];
        for (int i = 1; i < n; i++) {
            if ((nums[i] % 2) == (nums[i - 1] % 2)) {
                bad[i] = 1;
            }
        }
        
        
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + bad[i];
        }
        
     
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            
    
            if (prefix[r] - prefix[l] > 0) {
                ans[i] = false;
            } else {
                ans[i] = true;
            }
        }
        
        return ans;
    }
}
