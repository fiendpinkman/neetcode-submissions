class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = 1;
        for (int i = 1; i<dp.length; i++) {
            int j = i-1;
            dp[i] = Integer.MIN_VALUE;
            while (j>=0) {
                if (nums[i] == nums[j] + 1) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                } else if (nums[i] == nums[j]){
                    dp[i] = dp[i];
                }
                j--;
            }
            if (dp[i] == Integer.MIN_VALUE) {
                dp[i] = 1;
            }
        }
        for (int d: dp) {
            max = Math.max(d, max);
        }
        return max;
    }
}
