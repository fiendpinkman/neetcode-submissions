class Solution {
    int start = 0;
    int end = 0;
    int maxLength = 0;

    public String longestPalindrome(String s) {
        for (int i=0; i<s.length(); i++) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i+1);
        }
        return s.substring(start, end+1);
    }

    public void checkPalindrome(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            if ((right-left)>maxLength) {
                maxLength = right-left;
                start = left;
                end = right;
            }
            left--;
            right++;
        }
    }
}
