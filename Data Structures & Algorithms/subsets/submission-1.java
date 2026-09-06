class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> running = new ArrayList<>();
        backtrack(nums, 0, running, ans);
        return ans;
    }

    private void backtrack(
        int[] nums, int i, List<Integer> running, List<List<Integer>> ans) {
        // base case
        if (i==nums.length) {
            ans.add(new ArrayList<>(running));
            return;
        }

        // inclusion
        running.add(nums[i]);
        backtrack(nums, i+1, running, ans);
        
        // backtrack
        running.remove(Integer.valueOf(nums[i]));
        // exclusion;
        backtrack(nums, i+1, running, ans);
    }
}