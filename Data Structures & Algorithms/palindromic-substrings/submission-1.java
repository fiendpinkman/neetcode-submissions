class Solution {

    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            // odd use case
            count = count + checkPalindrome(s, i, i);
            // even use case
            count = count + checkPalindrome(s, i, i+1);
        }

        return count;
    }

    public int checkPalindrome(String s, int left, int right) {
        int count = 0;
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
