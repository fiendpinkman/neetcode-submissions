class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // bucket
        List<Integer>[] bucket = new List[nums.length+1];
        for (int i=0; i<bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }
        // frequency map
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            frequencies.put(nums[i],frequencies.getOrDefault(nums[i], 0)+1);
        }

        // fill bucket
        for (Map.Entry<Integer, Integer> frequency: frequencies.entrySet()) {
            int frequencyValue = frequency.getValue();
            int frequencyKey = frequency.getKey();
            List<Integer> b = bucket[frequencyValue];
            b.add(frequencyKey);
        }

        // traverse bucket
        int[] result = new int[k];
        int index = 0;
        for (int i=bucket.length-1; i>0; i--) {
            List<Integer> bList = bucket[i];
            for(Integer b: bList) {
                result[index] = b;
                index++;
                k--;
                if (k==0) {
                    return result;
                }
            }
        }
        return result;
    }
}
