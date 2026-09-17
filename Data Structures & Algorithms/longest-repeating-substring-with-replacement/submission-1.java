class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // 1. Direct O(1) Lookup
        int left = 0;
        int maxCount = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            // 2. Increment current char count & update maxCount in one line
            maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);

            // 3. Shift the window if invalid
            if ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++; // Shrink window from the left
            }

            // 4. Record largest valid window size
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
