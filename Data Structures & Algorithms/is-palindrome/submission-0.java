class Solution {
    public boolean isPalindrome(String s) {
        char[] cArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c: cArray) {
            if (isAlphanumeric(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        char[] sChar = sb.toString().toCharArray();
        int left = 0;
        int right = sChar.length - 1;
        while (left<right) {
            if (sChar[left] != sChar[right]) {
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
