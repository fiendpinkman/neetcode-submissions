class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> iMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int difference = target - nums[i];
            if (iMap.get(difference) != null) {
                return new int[]{iMap.get(difference), i};
            }
            iMap.put(nums[i], i);
        }
        return result;
    }
}
