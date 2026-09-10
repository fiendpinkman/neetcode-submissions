class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int maxProduct = nums[0];
        int leftMul = 1;
        int rightMul = 1;
        for (int i=0; i<length; i++) {
            if (leftMul == 0) leftMul = 1;
            if (rightMul == 0) rightMul = 1;
            leftMul = leftMul * nums[i];
            rightMul = rightMul * nums[length-i-1];
            int maxLR = Math.max(leftMul, rightMul);

            maxProduct = Math.max(maxProduct, maxLR);
        }
        return maxProduct;
    }
}
