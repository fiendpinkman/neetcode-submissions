class Solution {
    int count = 0;

    public int countSubstrings(String s) {
        for(int i=0; i<s.length(); i++) {
            // odd use case
            checkPalindrome(s, i, i);
            // even use case
            checkPalindrome(s, i, i+1);
        }

        return count;
    }

    public void checkPalindrome(String s, int left, int right) {

        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
