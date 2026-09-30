class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i=2; i<dp.length; i++) {
            int oneDigit = Integer.valueOf(s.substring(i-1,i));
            int twoDigit = Integer.valueOf(s.substring(i-2,i));
            int a = 0, b= 0;
            if (oneDigit>0) {
                a = dp[i-1];
            }

            if (twoDigit>=10 && twoDigit<=26) {
                b = dp[i-2];
            }

            dp[i] = a + b;
        }
        return dp[dp.length-1];
    }
}
