class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> setChar = new HashSet<>();
        int l = 0;
        int res = 0;
        for (int r=0; r<s.length() ;r++) {
            while (setChar.contains(s.charAt(r))) {
                setChar.remove(s.charAt(l));
                l++;
            }
            setChar.add(s.charAt(r));
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
