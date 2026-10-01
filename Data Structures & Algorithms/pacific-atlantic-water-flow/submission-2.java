class Solution {
    int[][] heights;
    boolean[][] visited;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        this.heights = heights;
        visited = new boolean[heights.length][heights[0].length];
        for (int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                visited = new boolean[heights.length][heights[0].length];
                int currentValue = heights[i][j];
                boolean[] result = dfs(i,j, currentValue);
                if (result[0] && result[1]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public boolean[] dfs(int row, int col, int pastValue) {
        boolean pacific = row<0 || col<0;
        boolean atlantic = row >= heights.length || col >= heights[0].length;
        
        if (pacific || atlantic) return new boolean[]{pacific, atlantic}; 
        if (visited[row][col]==true) return new boolean[]{false, false}; 
        if (pastValue<heights[row][col]) return new boolean[]{false, false}; 

        visited[row][col] = true;
        pastValue = heights[row][col];
        boolean[] top = dfs(row-1, col, pastValue);
        boolean[] bottom = dfs(row+1, col, pastValue); 
        boolean[] left = dfs(row, col-1, pastValue); 
        boolean[] right = dfs(row, col+1, pastValue);

        pacific = top[0] || bottom[0] || left[0] || right[0];
        atlantic = top[1] || bottom[1] || left[1] || right[1];
        
        return new boolean[]{pacific, atlantic};
    }
}
