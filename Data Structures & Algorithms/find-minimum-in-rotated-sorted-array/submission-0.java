class Solution {
    public int findMin(int[] nums) {
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int indexValueOfMax = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i]==maxValue) {
                indexValueOfMax = i;
                break;
            }
        }
        if(nums.length -1 == indexValueOfMax) {
            return nums[0];
        } else {
            return nums[indexValueOfMax+1];
        }
    }
}
