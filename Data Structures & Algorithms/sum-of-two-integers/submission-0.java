class Solution {
    public int getSum(int a, int b) {
        while (b!=0) {
            int carry = (a&b)<<1; // carry and shift one left
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
