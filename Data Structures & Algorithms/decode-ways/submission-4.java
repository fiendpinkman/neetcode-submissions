class Solution {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i=2; i<dp.length; i++) {
            int onedigit = Integer.valueOf(s.substring(i-1, i));
            int twodigit = Integer.valueOf(s.substring(i-2, i));

            int a = 0;
            int b = 0;

            // way to decode i-1 if the single digit is valid
            if (onedigit>=1) {
                a = dp[i-1];
            } 

            // way to decode i-2 if the double digit is valid
            if (twodigit>=10 && twodigit<=26) {
                b = dp[i-2];
            }
            dp[i] = a + b;
        }
        return dp[dp.length-1];
    }
}
