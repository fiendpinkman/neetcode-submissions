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
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> st = new PriorityQueue();
        for (int i=0; i<intervals.size(); i++) {
            if (st.isEmpty()) {
                st.add(intervals.get(i).end);
            } else {
                if (st.peek() > intervals.get(i).start) {
                    st.add(intervals.get(i).end);
                } else {
                    st.poll();
                    st.add(intervals.get(i).end);
                }
            }
        }
        return st.size();
        
    }
}
