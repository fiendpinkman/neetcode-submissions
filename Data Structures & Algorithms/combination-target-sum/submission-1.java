class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        List<Integer> running = new ArrayList<>();
        backTrack(0, target, running);
        return ans;
    }

    public void backTrack(int currentIndex, int target, List<Integer> running) {
        if (target == 0) {
            ans.add(new ArrayList<>(running));
            return;
        }

        if (target<0 || currentIndex == nums.length) return;

        // inclusion
        running.add(nums[currentIndex]);
        backTrack(currentIndex, target - nums[currentIndex], running);

        //exclusion
        running.remove(Integer.valueOf(nums[currentIndex]));
        backTrack(currentIndex+1, target, running);
    }
}
