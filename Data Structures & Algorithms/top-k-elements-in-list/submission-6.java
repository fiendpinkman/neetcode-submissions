class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        // create bucket
        List<Integer>[] bucket = new List[nums.length+1];

        // create frequencies
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num: nums) {
            frequencies.put(num, frequencies.getOrDefault(num,0)+1);
        }

        // fill bucket
        for (Map.Entry frequency: frequencies.entrySet()) {
            int key = (int) frequency.getKey();
            int value = (int) frequency.getValue();
            if (bucket[value]==null) {
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }

        int currentK = 0;
        for (int i=bucket.length-1; i>=1; i--) {
            List<Integer> cBucket = bucket[i];
            if(currentK<k && cBucket != null) {
                for (Integer element:cBucket) {
                    if (currentK<k) {
                        result[currentK] = element;
                        currentK++;
                    }
                }
            }
        }
        return result;
    }
}
