class Solution {
    public int maxSubArray(int[] nums) {
        int bag = 0;
        int currentMax = nums[0];
        for (int num : nums) {
            bag = Math.max(num, bag + num);
            currentMax = Math.max(bag, currentMax);
        }
        return currentMax;
    }
}
