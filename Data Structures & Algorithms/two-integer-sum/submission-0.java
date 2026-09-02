class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (numsMap.containsKey(remaining) && numsMap.get(remaining) != i) {
                return new int[]{i, numsMap.get(remaining)};
            }
        }
        return new int[0];
    }
}
