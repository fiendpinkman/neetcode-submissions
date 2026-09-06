class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> running = new ArrayList<>();
        backTrack(nums, target, 0, running, ans);
        return ans;
    }

    public void backTrack(int[] nums, int target, int currentIndex, List<Integer> running, List<List<Integer>> ans) {
        if(target==0) {
            ans.add(new ArrayList<>(running));
            return;
        }

        if (target<0) {
            return;
        }
        
        if(currentIndex==nums.length) {
            return;
        }

        // double inclusion
        running.add(nums[currentIndex]);
        backTrack(nums, target - nums[currentIndex], currentIndex, running, ans);

        // exclusion
        running.remove(Integer.valueOf(nums[currentIndex]));
        backTrack(nums, target, currentIndex+1, running, ans);
    }
}
