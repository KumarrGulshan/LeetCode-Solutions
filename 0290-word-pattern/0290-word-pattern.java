class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;
        HashMap<Character, String> charTowords = new HashMap<>();
        HashMap<String, Character> wordsTochar = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(charTowords.containsKey(ch)){
                if(!charTowords.get(ch).equals(word)){
                    return false;
                }
            }
            else{
                charTowords.put(ch, word);
            }
            if(wordsTochar.containsKey(word)){
                if(wordsTochar.get(word)!=ch){
                    return false;
                }
            }
            else{
                wordsTochar.put(word,ch);
            }
        }
        return true;
    }
}