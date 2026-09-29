class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        int count = 0;
        for (int i=1; i<intervals.length; i++) {
            if (prevEnd > intervals[i][0]) {
                prevEnd = Math.min(intervals[i][1], prevEnd);
                count++;
            } else {
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}
