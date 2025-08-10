class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                sb.deleteCharAt(sb.length() - 1); // remove last added character
            } else {
                sb.append(ch); // add normal character
            }
        }
        
        return sb.toString();
    }
}
