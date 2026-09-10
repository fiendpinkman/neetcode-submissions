/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (Interval interval: intervals) {
            if (q.isEmpty()) {
                q.add(interval.end);
                continue;
            }

            if (interval.start>=q.peek()) {
                q.remove();
            }

            q.add(interval.end);
        }
        return q.size();
    }
}
