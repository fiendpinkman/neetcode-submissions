class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        int minSpeed = end;
        while(start<=end) {
            int mid = (start+end)/2;
            if (speedTaken(piles, mid)<=h) {
                minSpeed = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minSpeed;
    }

    public static long speedTaken(int[] piles, int speed) {
        long timeTaken = 0;
        for (int pile:piles) {
            timeTaken += (long) Math.ceil((1.0*pile)/speed);
        }
        return timeTaken;
    }
}
