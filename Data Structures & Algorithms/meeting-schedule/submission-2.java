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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // first sort the interval
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // check if next start time is less than the past end time.
        for (int i= 1; i<intervals.size(); i++) {
            if (intervals.get(i-1).end > intervals.get(i).start) {
                return false;
            }
        }
        return true;
    }
}
