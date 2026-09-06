class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getPermutation(nums, 0, ans);
        return ans;
    }

    public void getPermutation(int[] nums, int index, List<List<Integer>> ans) {
        if(index==nums.length) {
            ans.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for (int i = index; i<nums.length; i++) {

            // swap
            int temp1 = nums[index];
            nums[index] = nums[i];
            nums[i] = temp1;

            getPermutation(nums, index+1, ans);

            //back track swap
            int temp2 = nums[index];
            nums[index] = nums[i];
            nums[i] = temp2;
        }
    }
}
