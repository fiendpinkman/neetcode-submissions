class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backTrack(0, s, path, res);
        return res;
    }

    public void backTrack(int index, String s, List<String> path, List<List<String>> res) {
        if(s.length()==index) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=index; i<s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                backTrack(i+1, s, path, res);
                // backTrack
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex<=endIndex) {
            if (s.charAt(startIndex++) != s.charAt(endIndex--)) {
                return false;
            }
        }
        return true;
    }
}
