class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length<=1) {
            return true;
        }
        int j = nums.length-2;
        int i = nums.length-1;
        while (i>=0 && j>=0) {
            if (nums[j]>=i-j) {
                i = j;
                j = i - 1;
            } else {
                j--;
            }
        }
        return (i==0);
    }
}
