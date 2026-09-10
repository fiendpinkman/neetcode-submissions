class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount<1) return 0;

        int[] dp = new int[amount+1];

        // for each amount how many min coins are required;
        for (int i = 1; i<dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;

            // go through each coins
            for (int coin: coins) {
                if (i>=coin && dp[i-coin]!=Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1+ dp[i-coin]);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
