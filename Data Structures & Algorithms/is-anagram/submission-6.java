class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sFrequency = new HashMap<>();
        for (char sChar: s.toCharArray()) {
            sFrequency.put(sChar, sFrequency.getOrDefault(sChar, 0) + 1); 
        }

        Map<Character, Integer> tFrequency = new HashMap<>();
        for (char tChar: t.toCharArray()) {
            tFrequency.put(tChar, tFrequency.getOrDefault(tChar, 0) + 1); 
        }
        
        return sFrequency.equals(tFrequency);
    }
}
