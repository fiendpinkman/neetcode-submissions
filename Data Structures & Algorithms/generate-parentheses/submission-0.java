class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(0, 0, n, sb, ans);
        return ans;
    }

    public void backTrack(int open, int close, int n, StringBuilder sb, List<String> ans) {

        if (open==close && open == n) {
            ans.add(sb.toString());
            return;
        }

        if (open<n) {
            sb.append("(");
            backTrack(open+1, close, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
        if (close<open) {
            sb.append(")");
            backTrack(open, close+1, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
