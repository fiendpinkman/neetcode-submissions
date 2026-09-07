class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];

        // Calculate prefix
        int[] prefix = new int[length];
        prefix[0] = 1;
        for (int i=1; i<length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1]; 
        }

        //calculate suffix
        int[] suffix = new int[length];
        suffix[length-1]= 1;
        for (int i = length -2; i>=0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1]; 
        }

        // ans = prefix * suffix
        for (int i=0; i<length; i++) {
            ans[i] = prefix[i] * suffix[i]; 
        }
        return ans;
    }
}  
