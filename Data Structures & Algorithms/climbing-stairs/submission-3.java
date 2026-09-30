class Solution {
    public int climbStairs(int n) {
        if (n == 0) return n;
        int cur = 1;
        int next = 1;
        while ((n-1)!=0) {
            int temp = next;
            next = cur + next;
            cur = temp;
            n--;
        }
        return next;
    }
}
