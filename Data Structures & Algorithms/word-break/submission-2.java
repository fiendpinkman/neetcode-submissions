class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 1; i <=s.length() ; i++) {
            int j = i-1;
            while (j>=0) {
                String curS = s.substring(j, i);
                if (wordDict.contains(curS) && (j == 0 || (j-1 >=0 && dp[j-1] == true))) {
                    dp[i-1] = true;
                }
                j--;
            }
        }
        return dp[dp.length-1];
    }
}
