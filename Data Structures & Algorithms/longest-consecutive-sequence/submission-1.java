class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> iMap = new HashMap<>();
        for (int num:nums) {
            iMap.put(num, false);
        }

        int result = 0;
        for (int num: nums) {
            int currentResult = 0;
            if (iMap.get(num) == false) {
                currentResult++;
                int greater = num + 1;
                while(iMap.get(greater)!=null) {
                    currentResult++;
                    iMap.put(greater, true);
                    greater = greater + 1;
                }
        
                int lesser = num-1;
                while(iMap.get(lesser)!=null) {
                    currentResult++;
                    iMap.put(lesser, true);
                    lesser = lesser - 1;
                }
            }
            result = Math.max(result, currentResult);

        }

        return result;
    }
}
