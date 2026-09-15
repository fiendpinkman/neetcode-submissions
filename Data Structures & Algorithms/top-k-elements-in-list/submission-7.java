class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num: nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        List[] bucket = new List[nums.length+1];

        for (Map.Entry<Integer, Integer> frequency: frequencies.entrySet()) {
            int key = frequency.getKey();
            int value = frequency.getValue();

            if (bucket[value] == null) {
                bucket[value] = new ArrayList<Integer>();
            }
            bucket[value].add(key);
        }

        int[] result = new int[k];
        for (int i=bucket.length-1; i>=0; i--) {
            List<Integer> combo = bucket[i];
            if (combo != null) {
                for (Integer value: combo) {
                    if (k>0) {
                        result[k-1] = value;
                        k--;
                    }
                }
            }
        }
        return result;
    }
}
