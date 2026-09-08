class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return false;
        if (s.length() != t.length()) return false;
        
        // convert to toCharArray
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        // Arrays.sort
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        // Compare both array
        return Arrays.equals(sChar,tChar);

    }
}
