class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int length = nums.length;
        int[] dp = new int[length];
        for (int i=0; i<length; i++) {
            dp[i] = 1;
        }
        int i = 1;
        int j = 0;
        while (i<length) {
            if(nums[j]<nums[i]) {
                dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            j++;
            if (j==i) {
                j = 0;
                i++;
            }
        }
        for (int d: dp) {
            max = Math.max(max, d);
        }
        return max;
    }
}
