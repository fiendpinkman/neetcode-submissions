class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }

        int[][] withNew = new int[intervals.length+1][2];
        // first insert interval
        for (int i=0; i<intervals.length; i++) {
            withNew[i][0] = intervals[i][0];
            withNew[i][1] = intervals[i][1];
        }
        withNew[intervals.length][0] = newInterval[0];
        withNew[intervals.length][1] = newInterval[1];

        Arrays.sort(withNew, (a, b) -> Integer.compare(a[0], b[0]));
        // then find overlapping and combine
        int[][] result = new int[intervals.length+1][2];
        int prevStart = withNew[0][0];
        int prevEnd = withNew[0][1];
        int j = 0;
        for (int i=1; i<withNew.length; i++) {
            if (prevEnd >= withNew[i][0]) {
                prevEnd = Math.max(prevEnd, withNew[i][1]);
            } else {
                result[j][0] = prevStart;
                result[j][1] = prevEnd;
                j++;
                prevStart = withNew[i][0];
                prevEnd = withNew[i][1];
            }
        }
        result[j][0] = prevStart;
        result[j][1] = prevEnd;

        return Arrays.copyOf(result, j+1);
    }
}
