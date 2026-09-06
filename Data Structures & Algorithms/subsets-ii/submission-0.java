class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> running = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, 0, running, ans);
        return ans;
    }

    public void backTrack(int[] nums, int i, List<Integer> running, List<List<Integer>> ans) {
        if (i==nums.length) {
            ans.add(new ArrayList<>(running));
            return;
        }

        // inclusion
        running.add(nums[i]);
        backTrack(nums, i+1, running, ans);

        // exclusion
        running.remove(running.size()-1);
        while (i+1<nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        backTrack(nums, i+1, running, ans);
    }
}
