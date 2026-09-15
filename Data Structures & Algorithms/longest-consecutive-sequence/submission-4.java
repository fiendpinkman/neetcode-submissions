class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int num: nums) {
            visited.put(num, false);
        }

        int max = 0;
        for (int i=0; i<nums.length; i++) {
            int currentMax = 0;
            int value = nums[i];

            if (visited.get(value) == false) {
                currentMax++;
                visited.put(value, true);

                int incr = value - 1;
                while(visited.get(incr) != null) {
                    visited.put(incr, true);
                    incr = incr-1;
                    currentMax++;
                }

                int decr = value+1;
                while(visited.get(decr) != null) {
                    visited.put(decr, true);
                    decr = decr+1;
                    currentMax++;
                }
            }
            max = Math.max(currentMax, max);
        }

        return max;
    }
}
