class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> running = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, running, ans);
        return ans;
    }

    public void backTrack(int[] candidates, int target, int i, List<Integer> running, List<List<Integer>> ans) {

        if (target==0) {
            ans.add(new ArrayList<>(running));
            return;
        }
        
        if (i==candidates.length) {
            return;
        }

        if (target<0) {
            return;
        }
    
        // inclusion
        running.add(candidates[i]);
        backTrack(candidates, target-candidates[i], i+1, running, ans);
        
        running.remove(running.size()-1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        // exclusion
        backTrack(candidates, target, i+1, running, ans);
    }
}
