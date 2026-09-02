class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left<right) {
            while(left<right && !isAlphanumeric(s.charAt(left))) {
                left++;
            }
            while(left<right && !isAlphanumeric(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isAlphanumeric(char c) {
        // A-Z
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        // a-z
        else if (c >= 'a' && c <= 'z') {
            return true;
        }
        // 0-9
        else if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
