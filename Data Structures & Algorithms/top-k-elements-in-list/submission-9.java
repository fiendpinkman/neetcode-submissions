class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (Integer num: nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[1],a[1]));
        for (Map.Entry<Integer, Integer> entrySet : frequencies.entrySet()) {
            queue.add(new int[]{entrySet.getKey(), entrySet.getValue()});
        }

        int[] result = new int[k];
        while(k!=0) {
            int[] pollResult = queue.poll();
            result[k-1] = pollResult[0];
            k--;
        }

        return result;
    }
}
