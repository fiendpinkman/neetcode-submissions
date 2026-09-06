class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> running = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, nums.length, running, result);
        return result;
    }

    private void backtrack(int[] nums, int i, int n, List<Integer> running, List<List<Integer>> result) {
        if (i >= n) {
            result.add(running);
            return;
        }

        backtrack(nums, i + 1, n, running, result);
        List<Integer> updated = new ArrayList<>(running);
        updated.add(nums[i]);
        backtrack(nums, i + 1, n, updated, result);
    }
}
