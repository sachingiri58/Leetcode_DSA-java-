import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, wordSet, memo);
    }

    private List<String> dfs(String s, int start, Set<String> wordSet, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        
        List<String> result = new ArrayList<>();
        
        if (start == s.length()) {
            result.add("");  // base case: empty string
            return result;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordSet.contains(prefix)) {
                List<String> subSentences = dfs(s, end, wordSet, memo);
                for (String sub : subSentences) {
                    if (sub.isEmpty()) {
                        result.add(prefix);
                    } else {
                        result.add(prefix + " " + sub);
                    }
                }
            }
        }
        
        memo.put(start, result);
        return result;
    }
}
