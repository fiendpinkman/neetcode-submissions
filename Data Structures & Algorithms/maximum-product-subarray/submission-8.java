class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int leftMul = 1;
        int rightMul = 1;
        for (int i=0; i<nums.length; i++) {
            if (leftMul == 0) leftMul = 1;
            if (rightMul == 0) rightMul = 1;

            leftMul = leftMul * nums[i];
            rightMul = rightMul * nums[nums.length-1-i];
            int maxLR = Math.max(leftMul, rightMul);

            maxProduct = Math.max(maxProduct, maxLR);
        }
        return maxProduct;
    }
}
