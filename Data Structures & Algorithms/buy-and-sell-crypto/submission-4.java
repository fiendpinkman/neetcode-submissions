class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
                right++;
            } else {
                int currentProfit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, currentProfit);
                right++;
            }
        }
        return maxProfit;
    }
}
