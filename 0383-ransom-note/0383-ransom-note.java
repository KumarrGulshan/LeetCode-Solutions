class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charcount = new int[26];
        for(int i=0; i<magazine.length(); i++){
            charcount[magazine.charAt(i)-'a']++;    
            } 
        for(int i=0; i<ransomNote.length(); i++){
          int index = ransomNote.charAt(i) - 'a';
          if(charcount[index] == 0){
             return false;
            }
        charcount[index]--;
        }
        return true;
    }
}