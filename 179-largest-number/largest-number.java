import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
      int n =nums.length;
      String[] s =new String[n];
      for(int i=0;i<n;i++)  
      s[i] = String.valueOf(nums[i]);
      Arrays.sort(s,(a,b)->(b+a).compareTo(a+b));
      StringBuilder sc=new StringBuilder();
      for(String str :s)
             sc.append(str);

      String result=sc.toString();
      return result.startsWith("0") ? "0" :result;
    }
}