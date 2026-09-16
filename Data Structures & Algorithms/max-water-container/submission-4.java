class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left<right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];
            int width = right - left;
            int height = Math.min(leftHeight, rightHeight);
            int currentArea = width * height;
            maxArea = Math.max(maxArea, currentArea);

            if (leftHeight>=rightHeight) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
