class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            int remaining = target - nums[i];
            if (freq.get(remaining) != null) {
                return new int[]{freq.get(remaining), i};
            }
            freq.put(nums[i], i);
        }
        return new int[2];
    }
}
