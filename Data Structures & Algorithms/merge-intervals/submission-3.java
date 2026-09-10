class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        int[] temp = new int[2];
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int j = 0;
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // overlap happening
            if ((prevStart<=currentStart && currentStart<=prevEnd)) {
                prevStart = Math.min(prevStart, currentStart);
                prevEnd = Math.max(prevEnd, currentEnd);
            } else {
                result[j][0] = prevStart;
                result[j][1] = prevEnd; 
                prevStart = currentStart;
                prevEnd = currentEnd;
                j++;
            }
        }

        result[j][0] = prevStart;
        result[j][1] = prevEnd;
        
        return Arrays.copyOf(result, j+1);
    }
}
