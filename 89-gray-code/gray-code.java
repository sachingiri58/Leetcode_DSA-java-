class Solution {
    public List<Integer> grayCode(int n) {
      List<Integer> res = new ArrayList<>();
        int total = 1 << n; // 2^n
        for (int i = 0; i < total; i++) {
           
            res.add(i ^ (i >> 1));
        }
        return res;
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.grayCode(2)); 
        System.out.println(sol.grayCode(3)); 
      
    }
}