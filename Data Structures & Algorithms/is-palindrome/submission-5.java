class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left<right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (!isAlphanumeric(leftChar)) {
                left++;
            } else if (!isAlphanumeric(rightChar)) {
                right--;
            } else if (leftChar == rightChar) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isAlphanumeric(char c) {
        if ((c >= 'a' && c <='z') || (c >= 'A' && c <='Z') || (c >= '0' && c <='9')) return true;
        return false;
    }
}
