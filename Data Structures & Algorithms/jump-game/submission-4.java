class Solution {
    public boolean canJump(int[] nums) {
        int j = nums.length - 1;
        int i = j - 1;

        while (i>=0) {

            // reachable
            if (nums[i] >= (j -i)) {
                j = i;
                i--;
            } 
            // not reachable shift left;
            else {
                i--;
            }
        }

        return j == 0;
    }
}
