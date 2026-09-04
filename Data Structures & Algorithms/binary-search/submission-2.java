class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        while (start<=end) {
            int mid = start + (end-start) / 2;
            int currentValue = nums[mid];
            if (currentValue == target) {
                return mid;
            } else if (currentValue < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start == end && nums[start] == target) {
            return start;
        } else {
            return -1;
        }
    }
}
