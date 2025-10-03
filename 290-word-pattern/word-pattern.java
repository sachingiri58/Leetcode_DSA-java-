import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        
        Map<Character, String> mapChar = new HashMap<>();
        Map<String, Character> mapWord = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            
            if (mapChar.containsKey(c) && !mapChar.get(c).equals(w)) return false;
            if (mapWord.containsKey(w) && mapWord.get(w) != c) return false;
            
            mapChar.put(c, w);
            mapWord.put(w, c);
        }
        
        return true;
    }
}
