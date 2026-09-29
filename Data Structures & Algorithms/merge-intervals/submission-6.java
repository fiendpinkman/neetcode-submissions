class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] result = new int[intervals.length][2];
        int[] temp = new int[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        int count = 0;
        for (int i=1; i<intervals.length; i++) {
            if (temp[1]>=intervals[i][0]) {
                temp[1] = Math.max(intervals[i][1], temp[1]);
            } else {
                result[count][0] = temp[0];
                result[count][1] = temp[1];
                count++;
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
            }
        }
        result[count][0] = temp[0];
        result[count][1] = temp[1];
        return Arrays.copyOf(result, count+1);
    }
}
