class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> mNums = new HashMap<>();
        for (int i =0 ; i<nums.length; i++) {
            mNums.put(nums[i], i);
        }

        for (int i =0 ; i<nums.length; i++) {
            int remaning = target - nums[i];
            if (mNums.get(remaning) != null && mNums.get(remaning)!=i) {
                result[0] = i;
                result[1] = mNums.get(remaning);
                return result;
            }
        }
        return result;
    }
}
