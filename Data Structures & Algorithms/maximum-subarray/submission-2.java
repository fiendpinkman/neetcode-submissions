class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length<=1) {
            return nums[0];
        }

        int max = nums[0];
        int currentMax = nums[0];

        for (int i=1; i<nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
