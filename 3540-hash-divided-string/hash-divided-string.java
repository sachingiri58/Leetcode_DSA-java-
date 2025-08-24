class Solution {
    public String stringHash(String s, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            int t = 0;
            for (int j = i; j < i + k; ++j) {
                t += s.charAt(j) - 'a';
            }
            char c = (char) ('a' + (t % 26));
            ans.append(c);
        }
        return ans.toString();
    }
}
