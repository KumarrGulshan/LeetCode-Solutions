import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#'); 
                sb.append(count[i]);
            }
            String signature = sb.toString();
            
            if (!map.containsKey(signature)) {
                map.put(signature, new ArrayList<>());
            }
            map.get(signature).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}