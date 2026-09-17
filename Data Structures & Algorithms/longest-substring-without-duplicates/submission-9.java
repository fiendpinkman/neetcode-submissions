class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int maxLength = 0;
        int left = 0;
        int right = 1;
        while (right<s.length()) {
            String currentString = s.substring(left, right);
            char currentLetter = s.charAt(right);
            if (currentString.contains(String.valueOf(currentLetter))) {
                left++;
            } else {
                maxLength = Math.max(maxLength, currentString.length());
                right++;
            }
        }
        return maxLength+1;
    }
}
