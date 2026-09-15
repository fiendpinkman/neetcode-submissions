class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int num: nums) {
            visited.put(num, false);
        }

        int max = 0;
        for (int i=0; i<nums.length; i++) {
            int currentMax = 1;
            int value = nums[i];

            if (visited.get(value) == false) {
                visited.put(value, true);

                int incr = value;
                while(visited.get(incr-1) != null && visited.get(incr-1) == false) {
                    visited.put(incr-1, true);
                    incr = incr-1;
                    currentMax++;
                }

                int decr = value;
                while(visited.get(decr+1) != null && visited.get(decr+1) == false) {
                    visited.put(decr+1, true);
                    decr = decr+1;
                    currentMax++;
                }
            }
            max = Math.max(currentMax, max);
        }

        return max;
    }
}
