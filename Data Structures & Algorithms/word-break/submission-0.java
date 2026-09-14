class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLength = 0;
        for (String word: wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=0;i<=s.length(); i++) {
            for (int j=i; j>0 && (i-j)<maxLength; j--) {
                String currentWord = s.substring(j-1, i);
                if (wordDict.contains(currentWord) && j-1>=0 && dp[j-1] != false) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
